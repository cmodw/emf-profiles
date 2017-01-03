/**
 * Copyright (c) 2012 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.emfprofile.application.decorator.gmf.propertytester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.modelversioning.emfprofile.application.decorator.gmf.EMFProfileApplicationDecoratorImpl;

/**
 * @author <a href="mailto:becirb@gmail.com">Becir Basic</a>
 *
 */
public class SelectionContainsModelElement extends PropertyTester {

	/**
	 * 
	 */
	public SelectionContainsModelElement() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		if(EMFProfileApplicationDecoratorImpl.getPluginExtensionOperationsListener() == null)
			return false;
		if(receiver instanceof EditPart){
			EditPart editPart = (EditPart) receiver;
			Object model = editPart.getModel();
			if (model instanceof Node) {
				return true;
			}
		}
		return false;
	}

}
