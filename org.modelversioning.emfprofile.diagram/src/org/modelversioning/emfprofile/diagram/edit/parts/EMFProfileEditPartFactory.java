package org.modelversioning.emfprofile.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.modelversioning.emfprofile.diagram.part.EMFProfileVisualIDRegistry;

/**
 * @generated
 */
public class EMFProfileEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (EMFProfileVisualIDRegistry.getVisualID(view)) {

			case ProfileEditPart.VISUAL_ID:
				return new ProfileEditPart(view);

			case StereotypeEditPart.VISUAL_ID:
				return new StereotypeEditPart(view);

			case StereotypeNameEditPart.VISUAL_ID:
				return new StereotypeNameEditPart(view);

			case EClassEditPart.VISUAL_ID:
				return new EClassEditPart(view);

			case EClassNameEditPart.VISUAL_ID:
				return new EClassNameEditPart(view);

			case EPackageEditPart.VISUAL_ID:
				return new EPackageEditPart(view);

			case EPackageNameEditPart.VISUAL_ID:
				return new EPackageNameEditPart(view);

			case EEnumEditPart.VISUAL_ID:
				return new EEnumEditPart(view);

			case EEnumNameEditPart.VISUAL_ID:
				return new EEnumNameEditPart(view);

			case EDataTypeEditPart.VISUAL_ID:
				return new EDataTypeEditPart(view);

			case EDataTypeNameEditPart.VISUAL_ID:
				return new EDataTypeNameEditPart(view);

			case EDataTypeInstanceClassNameEditPart.VISUAL_ID:
				return new EDataTypeInstanceClassNameEditPart(view);

			case EAttributeEditPart.VISUAL_ID:
				return new EAttributeEditPart(view);

			case OperationEditPart.VISUAL_ID:
				return new OperationEditPart(view);

			case EAttribute2EditPart.VISUAL_ID:
				return new EAttribute2EditPart(view);

			case EOperationEditPart.VISUAL_ID:
				return new EOperationEditPart(view);

			case EClass2EditPart.VISUAL_ID:
				return new EClass2EditPart(view);

			case EClassName2EditPart.VISUAL_ID:
				return new EClassName2EditPart(view);

			case EEnumLiteralEditPart.VISUAL_ID:
				return new EEnumLiteralEditPart(view);

			case StereotypeTaggedValueCompEditPart.VISUAL_ID:
				return new StereotypeTaggedValueCompEditPart(view);

			case StereotypeMethodCompEditPart.VISUAL_ID:
				return new StereotypeMethodCompEditPart(view);

			case EClassAttributesEditPart.VISUAL_ID:
				return new EClassAttributesEditPart(view);

			case EClassOperationsEditPart.VISUAL_ID:
				return new EClassOperationsEditPart(view);

			case EPackageContentsEditPart.VISUAL_ID:
				return new EPackageContentsEditPart(view);

			case EClassAttributes2EditPart.VISUAL_ID:
				return new EClassAttributes2EditPart(view);

			case EClassOperations2EditPart.VISUAL_ID:
				return new EClassOperations2EditPart(view);

			case EEnumLiteralsEditPart.VISUAL_ID:
				return new EEnumLiteralsEditPart(view);

			case ExtensionEditPart.VISUAL_ID:
				return new ExtensionEditPart(view);

			case ExtensionLowerBoundUpperBoundEditPart.VISUAL_ID:
				return new ExtensionLowerBoundUpperBoundEditPart(view);

			case EClassESuperTypesEditPart.VISUAL_ID:
				return new EClassESuperTypesEditPart(view);

			case EReferenceEditPart.VISUAL_ID:
				return new EReferenceEditPart(view);

			case EReferenceNameEditPart.VISUAL_ID:
				return new EReferenceNameEditPart(view);

			case EReferenceLowerBoundUpperBoundEditPart.VISUAL_ID:
				return new EReferenceLowerBoundUpperBoundEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}
}
