package org.modelversioning.emfprofile.diagram.part;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.tooling.runtime.part.LastClickPositionProvider;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IEditorInput;
import org.modelversioning.emfprofile.IProfileFacade;
import org.modelversioning.emfprofile.Profile;
import org.modelversioning.emfprofile.impl.ProfileFacadeImpl;
import org.modelversioning.emfprofileapplication.util.ProfileApplicationAspectGenerator;

/**
 * @generated
 */
public class EMFProfileDiagramEditor extends DiagramDocumentEditor {

	/**
	 * @generated
	 */
	public static final String ID = "org.modelversioning.emfprofile.diagram.part.EMFProfileDiagramEditorID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final String CONTEXT_ID = "org.modelversioning.emfprofile.diagram.ui.diagramContext"; //$NON-NLS-1$

	/**
	* @generated
	*/
	private LastClickPositionProvider myLastClickPositionProvider;

	private ProfileApplicationAspectGenerator aspectGenerator = null;
	
	/**
	 * @generated
	 */
	public EMFProfileDiagramEditor() {
		super(true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Calls the {@link #beforeSave()} hook.
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		beforeSave();
		super.doSave(progressMonitor);
	}

	/**
	 * Before save hook.
	 */
	protected void beforeSave() {
		getEditingDomain().getCommandStack().execute(new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				IProfileFacade profileFacade = new ProfileFacadeImpl();
				for (Resource resource : getEditingDomain().getResourceSet().getResources()) {
					for (EObject root : resource.getContents()) {
						if (root instanceof Profile) {
							profileFacade.makeApplicable((Profile) root);
							if (aspectGenerator == null) {
								aspectGenerator = new ProfileApplicationAspectGenerator((Profile) root, resource.getURI());
							}
							aspectGenerator.saveOrCreateAspect();
						}
					}
				}
			}
		});
		new ValidateAction(this.getEditorSite().getPage()).run();
	}

	/**
	 * @generated
	 */
	protected String getContextID() {
		return CONTEXT_ID;
	}

	/**
	 * @generated
	 */
	protected PaletteRoot createPaletteRoot(PaletteRoot existingPaletteRoot) {
		PaletteRoot root = super.createPaletteRoot(existingPaletteRoot);
		new EMFProfilePaletteFactory().fillPalette(root);
		return root;
	}

	/**
	 * @generated
	 */
	protected PreferencesHint getPreferencesHint() {
		return EMFProfileDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	/**
	 * @generated
	 */
	public String getContributorId() {
		return EMFProfileDiagramEditorPlugin.ID;
	}

	/**
	 * @generated
	 */
	protected IDocumentProvider getDocumentProvider(IEditorInput input) {
		if (input instanceof URIEditorInput) {
			return EMFProfileDiagramEditorPlugin.getInstance().getDocumentProvider();
		}
		return super.getDocumentProvider(input);
	}

	/**
	 * @generated
	 */
	public TransactionalEditingDomain getEditingDomain() {
		IDocument document = getEditorInput() != null ? getDocumentProvider().getDocument(getEditorInput()) : null;
		if (document instanceof IDiagramDocument) {
			return ((IDiagramDocument) document).getEditingDomain();
		}
		return super.getEditingDomain();
	}

	/**
	 * @generated
	 */
	protected void setDocumentProvider(IEditorInput input) {
		if (input instanceof URIEditorInput) {
			setDocumentProvider(EMFProfileDiagramEditorPlugin.getInstance().getDocumentProvider());
		} else {
			super.setDocumentProvider(input);
		}
	}

	/**
	 * @generated
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		DiagramEditorContextMenuProvider provider = new DiagramEditorContextMenuProvider(this,
				getDiagramGraphicalViewer());
		getDiagramGraphicalViewer().setContextMenu(provider);
		getSite().registerContextMenu(ActionIds.DIAGRAM_EDITOR_CONTEXT_MENU, provider, getDiagramGraphicalViewer());
	}

	/**
	 * @generated
	 */
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getDiagramGraphicalViewer().addDropTargetListener(
				new DropTargetListener(getDiagramGraphicalViewer(), LocalSelectionTransfer.getTransfer()) {

					protected Object getJavaObject(TransferData data) {
						return LocalSelectionTransfer.getTransfer().nativeToJava(data);
					}

				});
		getDiagramGraphicalViewer().addDropTargetListener(
				new DropTargetListener(getDiagramGraphicalViewer(), LocalTransfer.getInstance()) {

					protected Object getJavaObject(TransferData data) {
						return LocalTransfer.getInstance().nativeToJava(data);
					}

				});
		startupLastClickPositionProvider();
	}

	/**
	* @generated
	*/
	protected void startupLastClickPositionProvider() {
		if (myLastClickPositionProvider == null) {
			myLastClickPositionProvider = new LastClickPositionProvider(this);
			myLastClickPositionProvider.attachToService();
		}
	}

	/**
	* @generated
	*/
	protected void shutDownLastClickPositionProvider() {
		if (myLastClickPositionProvider != null) {
			myLastClickPositionProvider.detachFromService();
			myLastClickPositionProvider.dispose();
			myLastClickPositionProvider = null;
		}
	}

	/**
	* @generated
	*/
	@Override
	public void dispose() {
		shutDownLastClickPositionProvider();
		super.dispose();
	}

	/**
	 * @generated
	 */
	private abstract class DropTargetListener extends DiagramDropTargetListener {

		/**
		 * @generated
		 */
		public DropTargetListener(EditPartViewer viewer, Transfer xfer) {
			super(viewer, xfer);
		}

		/**
		 * @generated
		 */
		protected List getObjectsBeingDropped() {
			TransferData data = getCurrentEvent().currentDataType;
			HashSet<URI> uris = new HashSet<URI>();

			Object transferedObject = getJavaObject(data);
			if (transferedObject instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection) transferedObject;
				for (Iterator<?> it = selection.iterator(); it.hasNext();) {
					Object nextSelectedObject = it.next();
					if (nextSelectedObject instanceof IAdaptable) {
						IAdaptable adaptable = (IAdaptable) nextSelectedObject;
						nextSelectedObject = adaptable.getAdapter(EObject.class);
					}

					if (nextSelectedObject instanceof EObject) {
						EObject modelElement = (EObject) nextSelectedObject;
						uris.add(EcoreUtil.getURI(modelElement));
					}
				}
			}

			ArrayList<EObject> result = new ArrayList<EObject>(uris.size());
			for (URI nextURI : uris) {
				EObject modelObject = getEditingDomain().getResourceSet().getEObject(nextURI, true);
				result.add(modelObject);
			}
			return result;
		}

		/**
		 * @generated
		 */
		protected abstract Object getJavaObject(TransferData data);

	}

}
