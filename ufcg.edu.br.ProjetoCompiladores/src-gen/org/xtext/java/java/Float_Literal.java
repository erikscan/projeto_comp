/**
 */
package org.xtext.java.java;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Float Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.java.java.Float_Literal#getDecimalDigits1 <em>Decimal Digits1</em>}</li>
 *   <li>{@link org.xtext.java.java.Float_Literal#getDecimalDigits2 <em>Decimal Digits2</em>}</li>
 *   <li>{@link org.xtext.java.java.Float_Literal#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see org.xtext.java.java.JavaPackage#getFloat_Literal()
 * @model
 * @generated
 */
public interface Float_Literal extends EObject
{
  /**
   * Returns the value of the '<em><b>Decimal Digits1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decimal Digits1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decimal Digits1</em>' attribute.
   * @see #setDecimalDigits1(int)
   * @see org.xtext.java.java.JavaPackage#getFloat_Literal_DecimalDigits1()
   * @model
   * @generated
   */
  int getDecimalDigits1();

  /**
   * Sets the value of the '{@link org.xtext.java.java.Float_Literal#getDecimalDigits1 <em>Decimal Digits1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decimal Digits1</em>' attribute.
   * @see #getDecimalDigits1()
   * @generated
   */
  void setDecimalDigits1(int value);

  /**
   * Returns the value of the '<em><b>Decimal Digits2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decimal Digits2</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decimal Digits2</em>' attribute.
   * @see #setDecimalDigits2(int)
   * @see org.xtext.java.java.JavaPackage#getFloat_Literal_DecimalDigits2()
   * @model
   * @generated
   */
  int getDecimalDigits2();

  /**
   * Sets the value of the '{@link org.xtext.java.java.Float_Literal#getDecimalDigits2 <em>Decimal Digits2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decimal Digits2</em>' attribute.
   * @see #getDecimalDigits2()
   * @generated
   */
  void setDecimalDigits2(int value);

  /**
   * Returns the value of the '<em><b>Exp</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exp</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' attribute.
   * @see #setExp(String)
   * @see org.xtext.java.java.JavaPackage#getFloat_Literal_Exp()
   * @model
   * @generated
   */
  String getExp();

  /**
   * Sets the value of the '{@link org.xtext.java.java.Float_Literal#getExp <em>Exp</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' attribute.
   * @see #getExp()
   * @generated
   */
  void setExp(String value);

} // Float_Literal
