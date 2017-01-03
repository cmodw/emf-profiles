/**
 * 
 */
package org.modelversioning.emfprofile.diagram.part;

import org.eclipse.jface.viewers.IFilter;
import org.modelversioning.emfprofile.diagram.edit.parts.EOperationEditPart;

/**
 * 
 *	@generated NOT
 */
public class EMFProfileMethodPropertySectionFilter implements IFilter {

	@Override
	public boolean select(Object toTest) { 
		System.out.println(toTest.toString());
		if (toTest instanceof EOperationEditPart) {
			return true;//((EOperation) toTest).eContainer().equals(Stereotype.class); 
		} 
		return false; 
	} 

}
