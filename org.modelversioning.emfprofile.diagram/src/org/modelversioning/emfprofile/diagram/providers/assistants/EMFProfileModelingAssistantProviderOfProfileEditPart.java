package org.modelversioning.emfprofile.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.modelversioning.emfprofile.diagram.providers.EMFProfileElementTypes;
import org.modelversioning.emfprofile.diagram.providers.EMFProfileModelingAssistantProvider;

/**
 * @generated
 */
public class EMFProfileModelingAssistantProviderOfProfileEditPart extends EMFProfileModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(5);
		types.add(EMFProfileElementTypes.Stereotype_2006);
		types.add(EMFProfileElementTypes.EClass_2002);
		types.add(EMFProfileElementTypes.EPackage_2003);
		types.add(EMFProfileElementTypes.EEnum_2004);
		types.add(EMFProfileElementTypes.EDataType_2005);
		return types;
	}

}
