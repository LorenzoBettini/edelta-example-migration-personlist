package edelta.example.migration.personlist.migrator;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;

import edelta.FromV1ToV2;
import edelta.lib.EdeltaVersionMigrator;
import persons.PersonsPackage;

public class PersonsModelMigrator {

	public Collection<Resource> execute(String modelPath) throws Exception {
		var edeltaMigrator = new EdeltaVersionMigrator();
		// load the current (latest) version of EPackage
		edeltaMigrator.loadCurrentEPackage(PersonsPackage.eINSTANCE);
		// register the Edelta migration code
		edeltaMigrator.registerMigration(FromV1ToV2::new);
		// load the models to check and migrate
		edeltaMigrator.addModelFileExtension(".persons");
		edeltaMigrator.loadModelsFrom(modelPath);
		// let the Edelta framework do the rest
		return edeltaMigrator.execute();
	}
}
