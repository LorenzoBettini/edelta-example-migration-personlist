/**
 */
package persons;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link persons.Person#getList <em>List</em>}</li>
 *   <li>{@link persons.Person#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see persons.PersonsPackage#getPerson()
 * @model abstract="true"
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>List</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link persons.List#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' container reference.
	 * @see #setList(List)
	 * @see persons.PersonsPackage#getPerson_List()
	 * @see persons.List#getMembers
	 * @model opposite="members" required="true" transient="false"
	 * @generated
	 */
	List getList();

	/**
	 * Sets the value of the '{@link persons.Person#getList <em>List</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' container reference.
	 * @see #getList()
	 * @generated
	 */
	void setList(List value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see persons.PersonsPackage#getPerson_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link persons.Person#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Person
