package org.modelversioning.emfprofile.diagram.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import org.modelversioning.emfprofile.diagram.edit.parts.EMFProfileEditPartFactory;
import org.modelversioning.emfprofile.diagram.edit.parts.ProfileEditPart;
import org.modelversioning.emfprofile.diagram.part.EMFProfileVisualIDRegistry;

/**
 * @generated
 */
public class EMFProfileEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public EMFProfileEditPartProvider() {
		super(new EMFProfileEditPartFactory(), EMFProfileVisualIDRegistry.TYPED_INSTANCE, ProfileEditPart.MODEL_ID);
	}
}
