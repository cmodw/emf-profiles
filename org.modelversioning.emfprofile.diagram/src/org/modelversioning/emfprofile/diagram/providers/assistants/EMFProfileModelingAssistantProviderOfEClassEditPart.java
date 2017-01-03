package org.modelversioning.emfprofile.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.modelversioning.emfprofile.diagram.edit.parts.EClass2EditPart;
import org.modelversioning.emfprofile.diagram.edit.parts.EClassEditPart;
import org.modelversioning.emfprofile.diagram.edit.parts.EDataTypeEditPart;
import org.modelversioning.emfprofile.diagram.edit.parts.EEnumEditPart;
import org.modelversioning.emfprofile.diagram.edit.parts.StereotypeEditPart;
import org.modelversioning.emfprofile.diagram.providers.EMFProfileElementTypes;
import org.modelversioning.emfprofile.diagram.providers.EMFProfileModelingAssistantProvider;

/**
 * @generated
 */
public class EMFProfileModelingAssistantProviderOfEClassEditPart extends EMFProfileModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(EMFProfileElementTypes.EAttribute_3004);
		types.add(EMFProfileElementTypes.EOperation_3005);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((EClassEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(EClassEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(EMFProfileElementTypes.EClassESuperTypes_4002);
		types.add(EMFProfileElementTypes.EReference_4003);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((EClassEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(EClassEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof StereotypeEditPart) {
			types.add(EMFProfileElementTypes.EClassESuperTypes_4002);
		}
		if (targetEditPart instanceof EClassEditPart) {
			types.add(EMFProfileElementTypes.EClassESuperTypes_4002);
		}
		if (targetEditPart instanceof EClass2EditPart) {
			types.add(EMFProfileElementTypes.EClassESuperTypes_4002);
		}
		if (targetEditPart instanceof StereotypeEditPart) {
			types.add(EMFProfileElementTypes.EReference_4003);
		}
		if (targetEditPart instanceof EClassEditPart) {
			types.add(EMFProfileElementTypes.EReference_4003);
		}
		if (targetEditPart instanceof EEnumEditPart) {
			types.add(EMFProfileElementTypes.EReference_4003);
		}
		if (targetEditPart instanceof EDataTypeEditPart) {
			types.add(EMFProfileElementTypes.EReference_4003);
		}
		if (targetEditPart instanceof EClass2EditPart) {
			types.add(EMFProfileElementTypes.EReference_4003);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((EClassEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(EClassEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == EMFProfileElementTypes.EClassESuperTypes_4002) {
			types.add(EMFProfileElementTypes.Stereotype_2006);
			types.add(EMFProfileElementTypes.EClass_2002);
			types.add(EMFProfileElementTypes.EClass_3002);
		} else if (relationshipType == EMFProfileElementTypes.EReference_4003) {
			types.add(EMFProfileElementTypes.Stereotype_2006);
			types.add(EMFProfileElementTypes.EClass_2002);
			types.add(EMFProfileElementTypes.EEnum_2004);
			types.add(EMFProfileElementTypes.EDataType_2005);
			types.add(EMFProfileElementTypes.EClass_3002);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((EClassEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(EClassEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(EMFProfileElementTypes.Extension_4005);
		types.add(EMFProfileElementTypes.EClassESuperTypes_4002);
		types.add(EMFProfileElementTypes.EReference_4003);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((EClassEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(EClassEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == EMFProfileElementTypes.Extension_4005) {
			types.add(EMFProfileElementTypes.Stereotype_2006);
		} else if (relationshipType == EMFProfileElementTypes.EClassESuperTypes_4002) {
			types.add(EMFProfileElementTypes.Stereotype_2006);
			types.add(EMFProfileElementTypes.EClass_2002);
			types.add(EMFProfileElementTypes.EClass_3002);
		} else if (relationshipType == EMFProfileElementTypes.EReference_4003) {
			types.add(EMFProfileElementTypes.Stereotype_2006);
			types.add(EMFProfileElementTypes.EClass_2002);
			types.add(EMFProfileElementTypes.EClass_3002);
		}
		return types;
	}

}
