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
		Collection<Resource> migrated = personsModelMigrator.execute(OUTPUT);
		EdeltaTestUtils.assertFilesAreEquals(
				EXPECTATIONS + TEST_MODEL,
				OUTPUT + TEST_MODEL);
		EdeltaTestUtils.assertResourcesAreValid(migrated);
	}

	@Test
	public void testFromV2() throws Exception {
		EdeltaTestUtils.copyDirectory(INPUTS + "v2", OUTPUT);
		personsModelMigrator.execute(OUTPUT);
		EdeltaTestUtils.assertFilesAreEquals(
				EXPECTATIONS + TEST_MODEL,
				OUTPUT + TEST_MODEL);
	}

}
