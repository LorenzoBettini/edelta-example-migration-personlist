/**
 */
package persons.tests;

import junit.textui.TestRunner;

import persons.Female;
import persons.PersonsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Female</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FemaleTest extends PersonTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FemaleTest.class);
	}

	/**
	 * Constructs a new Female test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FemaleTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Female test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Female getFixture() {
		return (Female)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PersonsFactory.eINSTANCE.createFemale());
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

} //FemaleTest
