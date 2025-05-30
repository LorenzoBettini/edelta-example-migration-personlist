package persons.migrator.tests;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Before;
import org.junit.Test;

import edelta.example.migration.personlist.migrator.PersonsModelMigrator;
import edelta.testutils.EdeltaTestUtils;

public class PersonsModelMigratorTest {

	private static final String OUTPUT = "output/";
	private static final String INPUTS = "inputs/";
	private static final String EXPECTATIONS = "expectations/";
	private static final String TEST_MODEL = "My.persons";

	private PersonsModelMigrator personsModelMigrator;

	@Before
	public void setup() throws IOException {
		EdeltaTestUtils.cleanDirectoryRecursive(OUTPUT);
		personsModelMigrator = new PersonsModelMigrator();
	}

	@Test
	public void testFromV1() throws Exception {
		EdeltaTestUtils.copyDirectory(INPUTS + "v1", OUTPUT);
		applyMigrationAndAssertCorrectness();
	}

	@Test
	public void testFromV2() throws Exception {
		EdeltaTestUtils.copyDirectory(INPUTS + "v2", OUTPUT);
		applyMigrationAndAssertCorrectness();
	}

	@Test
	public void testFromV3() throws Exception {
		EdeltaTestUtils.copyDirectory(INPUTS + "v3", OUTPUT);
		applyMigrationAndAssertCorrectness();
	}

	private void applyMigrationAndAssertCorrectness() throws Exception, IOException {
		Collection<Resource> migrated = personsModelMigrator.execute(OUTPUT);
		EdeltaTestUtils.assertFilesAreEquals(
				EXPECTATIONS + TEST_MODEL,
				OUTPUT + TEST_MODEL);
		EdeltaTestUtils.assertResourcesAreValid(migrated);
	}

}
