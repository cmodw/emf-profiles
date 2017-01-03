package org.modelversioning.emfprofile.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.modelversioning.emfprofile.diagram.edit.commands.EOperationCreateCommand;
import org.modelversioning.emfprofile.diagram.edit.commands.OperationCreateCommand;
import org.modelversioning.emfprofile.diagram.providers.EMFProfileElementTypes;

/**
 * @generated
 */
public class StereotypeMethodCompItemSemanticEditPolicy extends EMFProfileBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public StereotypeMethodCompItemSemanticEditPolicy() {
		super(EMFProfileElementTypes.Stereotype_2006);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (EMFProfileElementTypes.Operation_3007 == req.getElementType()) {
			return getGEFWrapper(new OperationCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
