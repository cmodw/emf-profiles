package org.modelversioning.emfprofile.diagram.sheet;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EOperationImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

public class EMFProfileMethodPropertySection extends AdvancedPropertySection
	implements IPropertySourceProvider {
	
	private EAnnotation e = EcoreFactory.eINSTANCE.createEAnnotation();
	
    public IPropertySource getPropertySource(Object object) {
        if (object instanceof IPropertySource) {
            return (IPropertySource) object;
        }
        AdapterFactory af = getAdapterFactory(object);
        if (af != null) {
            IItemPropertySource ips = (IItemPropertySource) af.adapt(e,
                    IItemPropertySource.class);
        	
        	//e.getDetails().add(new List<String, String>());
        	//((EOperation) object).getEAnnotations().add(e);
            if (ips != null) {
            	
                return new PropertySource(e, ips) {
 
                	//EAnnotation e = EcoreFactory.eINSTANCE.createEAnnotation();
                	
                    @Override
                    protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
                        //System.out.println("a! - "+itemPropertyDescriptor.getDisplayName(object));
                        return super.createPropertyDescriptor(itemPropertyDescriptor);
                    }
                };
            }
        }
        if (object instanceof IAdaptable) {
            return (IPropertySource) ((IAdaptable) object)
                    .getAdapter(IPropertySource.class);
        }
        return null;
    }

	protected IPropertySourceProvider getPropertySourceProvider() {
		return this;
	}
	
	protected Object transformSelection(Object selected) {
		//System.out.println("asdtransf");

		if (selected instanceof EditPart) {
			Object model = ((EditPart) selected).getModel();
			return model instanceof View ? ((View) model).getElement() : null;
		}
		if (selected instanceof View) {
			return ((View) selected).getElement();
		}
		if (selected instanceof IAdaptable) {
			View view = (View) ((IAdaptable) selected).getAdapter(View.class);
			if (view != null) {
				return view.getElement();
			}
		}
		return selected;
	}

	public void setInput(IWorkbenchPart part, ISelection selection) {
		System.out.println(selection.toString());
		if (selection.isEmpty()
				|| false == selection instanceof StructuredSelection) {
			super.setInput(part, selection);
			return;
		}
		final StructuredSelection structuredSelection = ((StructuredSelection) selection);
		ArrayList transformedSelection = new ArrayList(
				structuredSelection.size());
		for (Iterator it = structuredSelection.iterator(); it.hasNext();) {
			Object r = transformSelection(it.next());
			//if(r instanceof EOperation){
				//EAnnotation e = EcoreFactory.eINSTANCE.createEAnnotation();
	        	//e.setSource("body");
				//((EOperation) r).getEAnnotations().add(e);
			//}
			if (r != null) {
				transformedSelection.add(r);
			}
		}
		super.setInput(part, new StructuredSelection(transformedSelection));
	}

	protected AdapterFactory getAdapterFactory(Object object) {
		if (getEditingDomain() instanceof AdapterFactoryEditingDomain) {
			return ((AdapterFactoryEditingDomain) getEditingDomain())
					.getAdapterFactory();
		}
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(object);
		if (editingDomain != null) {
			return ((AdapterFactoryEditingDomain) editingDomain)
					.getAdapterFactory();
		}
		return null;
	}
}