/**
 * Copyright (c) 2010 - 2012 modelversioning.org
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.modelversioning.emfprofile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EOperationImpl;

import org.modelversioning.emfprofile.EMFProfilePackage;
import org.modelversioning.emfprofile.Operation;
import org.modelversioning.emfprofile.Position;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.modelversioning.emfprofile.impl.OperationImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.modelversioning.emfprofile.impl.OperationImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.modelversioning.emfprofile.impl.OperationImpl#getJoinpoint <em>Joinpoint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationImpl extends EOperationImpl implements Operation {
	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final Position POSITION_EDEFAULT = Position.AROUND;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected Position position = POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected static final String BODY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected String body = BODY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getJoinpoint() <em>Joinpoint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinpoint()
	 * @generated
	 * @ordered
	 */
	protected EOperation joinpoint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMFProfilePackage.Literals.OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(Position newPosition) {
		Position oldPosition = position;
		position = newPosition == null ? POSITION_EDEFAULT : newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMFProfilePackage.OPERATION__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(String newBody) {
		String oldBody = body;
		body = newBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMFProfilePackage.OPERATION__BODY, oldBody, body));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getJoinpoint() {
		if (joinpoint != null && joinpoint.eIsProxy()) {
			InternalEObject oldJoinpoint = (InternalEObject)joinpoint;
			joinpoint = (EOperation)eResolveProxy(oldJoinpoint);
			if (joinpoint != oldJoinpoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMFProfilePackage.OPERATION__JOINPOINT, oldJoinpoint, joinpoint));
			}
		}
		return joinpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation basicGetJoinpoint() {
		return joinpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoinpoint(EOperation newJoinpoint) {
		EOperation oldJoinpoint = joinpoint;
		joinpoint = newJoinpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EMFProfilePackage.OPERATION__JOINPOINT, oldJoinpoint, joinpoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EMFProfilePackage.OPERATION__POSITION:
				return getPosition();
			case EMFProfilePackage.OPERATION__BODY:
				return getBody();
			case EMFProfilePackage.OPERATION__JOINPOINT:
				if (resolve) return getJoinpoint();
				return basicGetJoinpoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EMFProfilePackage.OPERATION__POSITION:
				setPosition((Position)newValue);
				return;
			case EMFProfilePackage.OPERATION__BODY:
				setBody((String)newValue);
				return;
			case EMFProfilePackage.OPERATION__JOINPOINT:
				setJoinpoint((EOperation)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EMFProfilePackage.OPERATION__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case EMFProfilePackage.OPERATION__BODY:
				setBody(BODY_EDEFAULT);
				return;
			case EMFProfilePackage.OPERATION__JOINPOINT:
				setJoinpoint((EOperation)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EMFProfilePackage.OPERATION__POSITION:
				return position != POSITION_EDEFAULT;
			case EMFProfilePackage.OPERATION__BODY:
				return BODY_EDEFAULT == null ? body != null : !BODY_EDEFAULT.equals(body);
			case EMFProfilePackage.OPERATION__JOINPOINT:
				return joinpoint != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (position: ");
		result.append(position);
		result.append(", body: ");
		result.append(body);
		result.append(')');
		return result.toString();
	}

} //OperationImpl
