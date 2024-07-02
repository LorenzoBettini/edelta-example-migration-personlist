/**
 */
package persons;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link persons.List#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @see persons.PersonsPackage#getList()
 * @model
 * @generated
 */
public interface List extends EObject {
	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link persons.Person}.
	 * It is bidirectional and its opposite is '{@link persons.Person#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see persons.PersonsPackage#getList_Members()
	 * @see persons.Person#getList
	 * @model opposite="list" containment="true"
	 * @generated
	 */
	EList<Person> getMembers();

} // List
