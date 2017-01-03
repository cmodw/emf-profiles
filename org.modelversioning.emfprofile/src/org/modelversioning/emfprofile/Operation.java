/**
 * Copyright (c) 2010 - 2012 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.emfprofile;

import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.modelversioning.emfprofile.Operation#getPosition <em>Position</em>}</li>
 *   <li>{@link org.modelversioning.emfprofile.Operation#getBody <em>Body</em>}</li>
 *   <li>{@link org.modelversioning.emfprofile.Operation#getJoinpoint <em>Joinpoint</em>}</li>
 * </ul>
 *
 * @see org.modelversioning.emfprofile.EMFProfilePackage#getOperation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='joinpointTargetMustBeInExtendedClass'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL joinpointTargetMustBeInExtendedClass='self.joinpoint->notEmpty() implies self.eContainingClass.oclAsType(emfprofile::Stereotype).getAllExtensions()->exists(extension : Extension | extension.target.eOperations->exists(eo | eo = self.joinpoint))'"
 * @generated
 */
public interface Operation extends EOperation {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The default value is <code>"Around"</code>.
	 * The literals are from the enumeration {@link org.modelversioning.emfprofile.Position}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see org.modelversioning.emfprofile.Position
	 * @see #setPosition(Position)
	 * @see org.modelversioning.emfprofile.EMFProfilePackage#getOperation_Position()
	 * @model default="Around"
	 * @generated
	 */
	Position getPosition();

	/**
	 * Sets the value of the '{@link org.modelversioning.emfprofile.Operation#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see org.modelversioning.emfprofile.Position
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(Position value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see org.modelversioning.emfprofile.EMFProfilePackage#getOperation_Body()
	 * @model
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link org.modelversioning.emfprofile.Operation#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Joinpoint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Joinpoint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Joinpoint</em>' reference.
	 * @see #setJoinpoint(EOperation)
	 * @see org.modelversioning.emfprofile.EMFProfilePackage#getOperation_Joinpoint()
	 * @model
	 * @generated
	 */
	EOperation getJoinpoint();

	/**
	 * Sets the value of the '{@link org.modelversioning.emfprofile.Operation#getJoinpoint <em>Joinpoint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Joinpoint</em>' reference.
	 * @see #getJoinpoint()
	 * @generated
	 */
	void setJoinpoint(EOperation value);

} // Operation
