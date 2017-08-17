/**
 */
package org.xtext.java.java.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.java.java.Expression;
import org.xtext.java.java.JavaPackage;
import org.xtext.java.java.Statement;
import org.xtext.java.java.Switch_Statement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.java.java.impl.Switch_StatementImpl#getSw_exp <em>Sw exp</em>}</li>
 *   <li>{@link org.xtext.java.java.impl.Switch_StatementImpl#getCase_exp <em>Case exp</em>}</li>
 *   <li>{@link org.xtext.java.java.impl.Switch_StatementImpl#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Switch_StatementImpl extends MinimalEObjectImpl.Container implements Switch_Statement
{
  /**
   * The cached value of the '{@link #getSw_exp() <em>Sw exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSw_exp()
   * @generated
   * @ordered
   */
  protected Expression sw_exp;

  /**
   * The cached value of the '{@link #getCase_exp() <em>Case exp</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCase_exp()
   * @generated
   * @ordered
   */
  protected EList<Expression> case_exp;

  /**
   * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatements()
   * @generated
   * @ordered
   */
  protected EList<Statement> statements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Switch_StatementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return JavaPackage.Literals.SWITCH_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getSw_exp()
  {
    return sw_exp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSw_exp(Expression newSw_exp, NotificationChain msgs)
  {
    Expression oldSw_exp = sw_exp;
    sw_exp = newSw_exp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavaPackage.SWITCH_STATEMENT__SW_EXP, oldSw_exp, newSw_exp);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSw_exp(Expression newSw_exp)
  {
    if (newSw_exp != sw_exp)
    {
      NotificationChain msgs = null;
      if (sw_exp != null)
        msgs = ((InternalEObject)sw_exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavaPackage.SWITCH_STATEMENT__SW_EXP, null, msgs);
      if (newSw_exp != null)
        msgs = ((InternalEObject)newSw_exp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavaPackage.SWITCH_STATEMENT__SW_EXP, null, msgs);
      msgs = basicSetSw_exp(newSw_exp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.SWITCH_STATEMENT__SW_EXP, newSw_exp, newSw_exp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getCase_exp()
  {
    if (case_exp == null)
    {
      case_exp = new EObjectContainmentEList<Expression>(Expression.class, this, JavaPackage.SWITCH_STATEMENT__CASE_EXP);
    }
    return case_exp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Statement> getStatements()
  {
    if (statements == null)
    {
      statements = new EObjectContainmentEList<Statement>(Statement.class, this, JavaPackage.SWITCH_STATEMENT__STATEMENTS);
    }
    return statements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case JavaPackage.SWITCH_STATEMENT__SW_EXP:
        return basicSetSw_exp(null, msgs);
      case JavaPackage.SWITCH_STATEMENT__CASE_EXP:
        return ((InternalEList<?>)getCase_exp()).basicRemove(otherEnd, msgs);
      case JavaPackage.SWITCH_STATEMENT__STATEMENTS:
        return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case JavaPackage.SWITCH_STATEMENT__SW_EXP:
        return getSw_exp();
      case JavaPackage.SWITCH_STATEMENT__CASE_EXP:
        return getCase_exp();
      case JavaPackage.SWITCH_STATEMENT__STATEMENTS:
        return getStatements();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case JavaPackage.SWITCH_STATEMENT__SW_EXP:
        setSw_exp((Expression)newValue);
        return;
      case JavaPackage.SWITCH_STATEMENT__CASE_EXP:
        getCase_exp().clear();
        getCase_exp().addAll((Collection<? extends Expression>)newValue);
        return;
      case JavaPackage.SWITCH_STATEMENT__STATEMENTS:
        getStatements().clear();
        getStatements().addAll((Collection<? extends Statement>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case JavaPackage.SWITCH_STATEMENT__SW_EXP:
        setSw_exp((Expression)null);
        return;
      case JavaPackage.SWITCH_STATEMENT__CASE_EXP:
        getCase_exp().clear();
        return;
      case JavaPackage.SWITCH_STATEMENT__STATEMENTS:
        getStatements().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case JavaPackage.SWITCH_STATEMENT__SW_EXP:
        return sw_exp != null;
      case JavaPackage.SWITCH_STATEMENT__CASE_EXP:
        return case_exp != null && !case_exp.isEmpty();
      case JavaPackage.SWITCH_STATEMENT__STATEMENTS:
        return statements != null && !statements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //Switch_StatementImpl
