/**
 */
package persons.tests;

import junit.textui.TestRunner;

import persons.Male;
import persons.PersonsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Male</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MaleTest extends PersonTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MaleTest.class);
	}

	/**
	 * Constructs a new Male test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Male test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Male getFixture() {
		return (Male)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PersonsFactory.eINSTANCE.createMale());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //MaleTest
