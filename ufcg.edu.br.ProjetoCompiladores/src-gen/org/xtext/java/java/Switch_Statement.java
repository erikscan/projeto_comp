/**
 */
package org.xtext.java.java;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.java.java.Switch_Statement#getSw_exp <em>Sw exp</em>}</li>
 *   <li>{@link org.xtext.java.java.Switch_Statement#getCase_exp <em>Case exp</em>}</li>
 *   <li>{@link org.xtext.java.java.Switch_Statement#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see org.xtext.java.java.JavaPackage#getSwitch_Statement()
 * @model
 * @generated
 */
public interface Switch_Statement extends EObject
{
  /**
   * Returns the value of the '<em><b>Sw exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sw exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sw exp</em>' containment reference.
   * @see #setSw_exp(Expression)
   * @see org.xtext.java.java.JavaPackage#getSwitch_Statement_Sw_exp()
   * @model containment="true"
   * @generated
   */
  Expression getSw_exp();

  /**
   * Sets the value of the '{@link org.xtext.java.java.Switch_Statement#getSw_exp <em>Sw exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sw exp</em>' containment reference.
   * @see #getSw_exp()
   * @generated
   */
  void setSw_exp(Expression value);

  /**
   * Returns the value of the '<em><b>Case exp</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.java.java.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Case exp</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Case exp</em>' containment reference list.
   * @see org.xtext.java.java.JavaPackage#getSwitch_Statement_Case_exp()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getCase_exp();

  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.java.java.Statement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see org.xtext.java.java.JavaPackage#getSwitch_Statement_Statements()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getStatements();

} // Switch_Statement
