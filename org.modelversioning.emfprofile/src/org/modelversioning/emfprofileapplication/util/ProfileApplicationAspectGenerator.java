package org.modelversioning.emfprofileapplication.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.ajdt.internal.ui.lazystart.Utils;
import org.eclipse.ajdt.internal.utils.AJDTUtils;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IClasspathEntry;
//import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.modelversioning.emfprofile.EMFProfilePlugin;
import org.modelversioning.emfprofile.Operation;
import org.modelversioning.emfprofile.Position;
import org.modelversioning.emfprofile.Profile;
import org.modelversioning.emfprofile.Stereotype;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.packageadmin.PackageAdmin;

public class ProfileApplicationAspectGenerator {

	private static final String ASPECT_PACKAGE_NAME = "aspect";
	
	private Profile profile;
	private URI uri;
	private IProject project;
	private IJavaProject javaProject;
	private IPackageFragment pack;
	private IFolder srcFolder;
	private String packageName;
	private List<String> supplementBundles;
	
	public ProfileApplicationAspectGenerator(Profile profile, URI uri) {
		this.profile = profile;
		this.uri = uri;
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		project  = root.getProject(uri.segment(1));
		packageName = project.getName() + "." + ASPECT_PACKAGE_NAME;
		javaProject = JavaCore.create(project);
		supplementBundles = new ArrayList<String>();
		try {
			pack = javaProject.findPackageFragmentRoot(new Path(project.getName()).append("src").makeAbsolute())
					.getPackageFragment(project.getName()+"."+ASPECT_PACKAGE_NAME);
		} catch (JavaModelException e) {	}
	}
	
	public void saveOrCreateAspect() {
		if (!profile.getStereotypes().isEmpty() && hasOperations()) {
			prepareWorkspace();
			saveAspect();
			try {
				if(!project.hasNature(Utils.ID_NATURE)){
					createManifest();
					configureAspectJNature();
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean hasOperations() {
		for (Stereotype stereotype : profile.getStereotypes()){
			for (Operation operation : stereotype.getOperations()){
				if(operation.getJoinpoint() != null && operation.getBody() != null)
					return true;
			}
		}
		return false;
	}

	private void prepareWorkspace() {
	    try {
	    	//&& (hasPluginManifest(project) || hasBundleManifest(project)
	    	configureJavaNature();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void configureJavaNature() throws CoreException {
		if(!project.hasNature(JavaCore.NATURE_ID)){
			setJavaNature();
			createSrcAndBin();
			createBuildProperties();
			setClasspath();
			pack = javaProject.getPackageFragmentRoot(srcFolder).createPackageFragment(packageName, false, null);
		}
	}
	
	private void setJavaNature() throws CoreException {
        IProjectDescription description = project.getDescription();
        String[] prevNatures = description.getNatureIds();
        String[] newNatures = new String[prevNatures.length + 1];
        System.arraycopy(prevNatures, 0, newNatures, 1, prevNatures.length);
        newNatures[0] = JavaCore.NATURE_ID;
        description.setNatureIds(newNatures);
        project.setDescription(description, null);
    }
    
	private void createSrcAndBin() throws CoreException {
		srcFolder = createFolder("src", project);
		IFolder binDir = createFolder("bin", project);
		javaProject.setOutputLocation(binDir.getFullPath(), null);
	}
	
    private void createManifest() throws CoreException {
    	StringBuilder maniContent = new StringBuilder("Manifest-Version: 1.0\n");
    	maniContent.append("Bundle-ManifestVersion: 2\n");
    	maniContent.append("Bundle-Name: " + project.getName() + "\n");
    	maniContent.append("Bundle-SymbolicName: " + project.getName() + "; singleton:=true\n");
    	maniContent.append("Bundle-Version: 1.0.0\n");
    	maniContent.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.8\n");
    	maniContent.append("Require-Bundle: " + supplementBundles.get(0));
    	for (int i = 1; i < supplementBundles.size(); i++) {
            maniContent.append(",\n " + supplementBundles.get(i));
    	}
        maniContent.append("\n");
    	maniContent.append("Export-Package: " + packageName + ";aspects=\"profile\"\n");
        maniContent.append("Import-Package: org.modelversioning.emfprofile,\n");
        maniContent.append(" org.modelversioning.emfprofile.application.registry,\n");
        maniContent.append(" org.modelversioning.emfprofile.application.registry.ui.observer,\n");
        maniContent.append(" org.modelversioning.emfprofileapplication\n");
    	maniContent.append("Eclipse-SupplementBundle: " + supplementBundles.get(0));
        for (int i = 1; i < supplementBundles.size(); i++) {
        	maniContent.append(",\n " + supplementBundles.get(i));
        }
        maniContent.append("\n");
        IFolder metaInf = createFolder("META-INF", project);
        createFile("MANIFEST.MF", metaInf, maniContent.toString());
    }
    
    private void createBuildProperties() throws CoreException {
    	StringBuilder bpContent = new StringBuilder("source.. = src/\n");
        bpContent.append("output.. = bin/\n");
        bpContent.append("bin.includes = META-INF/,\\\n");
        bpContent.append("\ticons/,\\\n");
        bpContent.append("\tplugin.xml,\\\n");
        bpContent.append("\tprofile.emfprofile_diagram,\\\n");
        bpContent.append("\t.\n");
        bpContent.append("\n");
        createFile("build.properties", project, bpContent.toString());
    }
    
    private void setClasspath() throws JavaModelException {
    	/*try{
	        javaProject.getRawClasspath();
    	} catch (JavaModelException e){
    	}*/
	        javaProject.setRawClasspath(new IClasspathEntry[0], null);
    	IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(srcFolder);
        IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
        IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 3];
        System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
        newEntries[oldEntries.length] = JavaRuntime.getDefaultJREContainerEntry();
        newEntries[oldEntries.length + 1] = JavaCore.newSourceEntry(root.getPath());
        newEntries[oldEntries.length + 2] = JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins"));
        javaProject.setRawClasspath(newEntries, null);
    }
    
	private void configureAspectJNature() throws CoreException {
		if(!project.hasNature(Utils.ID_NATURE)){
			setAspectJNature();
		}
	}
	
	private void setAspectJNature() throws CoreException {
		AJDTUtils.addAspectJNature(project, false);
	}
	
	@SuppressWarnings("deprecation")
	private String getBundleName(String packageName) {
		final BundleContext bundleContext = EMFProfilePlugin.getPlugin().getBundle().getBundleContext();
	    final ServiceReference<?> serviceRef = bundleContext.getServiceReference(PackageAdmin.class.getName());
	    final PackageAdmin admin = (PackageAdmin) bundleContext.getService(serviceRef);
		return admin.getExportedPackage(packageName).getExportingBundle().getSymbolicName();
				
				/*
	    Bundle[] bundles = Platform.getBundles(bundleName, version);
	    if (bundles != null)
	        return bundles;

	    // Accessing unresolved bundle
	    final BundleContext bundleContext = getBundle().getBundleContext();
	    final ServiceReference<?> serviceRef = bundleContext.getServiceReference(PackageAdmin.class.getName());
	    final PackageAdmin admin = (PackageAdmin) bundleContext.getService(serviceRef);
	    bundles = admin.getBundles(bundleName, version);
	    if (bundles != null && bundles.length > 0)
	        return bundles;
	    return null;*/
	}
	
	private void addSupplementBundleFromPackage(String packageName) {
		supplementBundles.add(getBundleName(packageName));
	}
	
	private void saveAspect() {
		StringBuilder fileContent = new StringBuilder();
		for (Stereotype s : profile.getStereotypes()){
			for(Operation operation : s.getOperations()){
				String returnType = "";
				if(operation.getPosition().equals(Position.AROUND))
					returnType = operation.getJoinpoint().getEType() == null ? "void" : operation.getJoinpoint().getEType().getInstanceTypeName();
				String returnTypeOp = operation.getJoinpoint().getEType() == null ? "void" : operation.getJoinpoint().getEType().getInstanceTypeName();
				String joinpointName = operation.getJoinpoint().getName();
				String joinpointClass = operation.getJoinpoint().getEContainingClass().getName();
				String joinpointPackage = operation.getJoinpoint().getEContainingClass().getEPackage().getName();
				String relativePosition = operation.getPosition().name();
				String body = operation.getBody();
				String stereotypeID = s.getEPackage().getNsURI()+s.getName();
				addSupplementBundleFromPackage(joinpointPackage);
				fileContent.append("package " + packageName + ";\n\n");
				fileContent.append("import org.modelversioning.emfprofile.application.registry.ProfileApplicationRegistry;\n");
				fileContent.append("import org.modelversioning.emfprofile.application.registry.ui.observer.ActiveEditorObserver;\n");
				fileContent.append("import org.modelversioning.emfprofileapplication.StereotypeApplication;\n\n");
				fileContent.append("public aspect " + uri.trimFileExtension().lastSegment() + " {\n\n");
				fileContent.append("\t" + returnType + " " + relativePosition.toLowerCase()
					+"(" + joinpointPackage + "." + joinpointClass + " eObject): "
					+ "target(eObject) && execution(" + returnTypeOp + " " + joinpointName + "()) {\n");
				fileContent.append("\t\tString stereotypeID = \"" + stereotypeID + "\";\n");
				fileContent.append("\t\tString modelId = ActiveEditorObserver.INSTANCE.getModelIdForLastActiveWorkbenchPart();\n");
				fileContent.append("\t\tStereotypeApplication stereotypeApplication = "
						+ "ProfileApplicationRegistry.INSTANCE.getStereotypeApplication(modelId, eObject, stereotypeID);\n");
				fileContent.append("\t\tif(stereotypeApplication != null) {\n");
				fileContent.append("\t\t\t"+body+"\n");
				fileContent.append("\t\t}");
				if(operation.getPosition().equals(Position.AROUND)){
					fileContent.append(" else {\n\t\t\t");
					if (!returnType.equals("void"))
						fileContent.append("return ");
					fileContent.append("proceed(eObject);\n");
					fileContent.append("\t\t}");
				}
				fileContent.append("\n\n\t}\n");
				fileContent.append("}");
			}
		}
		if(fileContent.length()>0) {
		    try {
		    	String aspectPath = uri.trimFileExtension().appendFileExtension("aj").lastSegment();
		    	pack.createCompilationUnit(aspectPath, fileContent.toString(), true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	private IFolder createFolder(String name, IContainer container) throws CoreException {
		IFolder folder = container.getFolder(new Path(name));
		if(!folder.exists()){
			folder.create(false, true, null);
		}
		return folder;
	}
	
	private IFile createFile(String name, IContainer container, String content) throws CoreException {
		IFile file = container.getFile(new Path(name));
		InputStream stream = null;
        try {
	        stream = new ByteArrayInputStream(content.getBytes(file.getCharset()));
	        if (file.exists()) {
	                file.setContents(stream, true, true, null);
	        }
	        else {
	                file.create(stream, true, null);
	        }
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            if (null != stream) {
                try {
                	stream.close();
                }
                catch (IOException e) {
                        e.printStackTrace();
                }
            }
        }
        return file;
	}
}
