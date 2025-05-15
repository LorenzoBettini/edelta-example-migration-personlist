package edelta.example.migration.personlist.editor.handlers;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import edelta.example.migration.personlist.migrator.PersonsModelMigrator;
import edelta.lib.EdeltaResourceUtils;
import persons.presentation.PersonsEditorPlugin;

public class PersonsModelMigrationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		var root = ResourcesPlugin.getWorkspace().getRoot();
		var allProjects = root.getProjects();
		var migratedResources = new ArrayList<String>();
		for (IProject project : allProjects) {
			if (project.isOpen()) {
				var projectPath = project.getLocation().toString();
				var personsMigrator = new PersonsModelMigrator();
				try {
					var migrated = personsMigrator.execute(projectPath);
					migratedResources.addAll(migrated.stream()
						.map(m -> EdeltaResourceUtils.getRelativePath(m, projectPath))
						.toList());
				} catch (Exception e) {
					PersonsEditorPlugin.INSTANCE.log(e);
				}
			}
		}
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		if (migratedResources.isEmpty()) {
			MessageDialog.openInformation(window.getShell(), "Migration",
				"No model files to migrate");
		} else {
			MessageDialog.openInformation(window.getShell(), "Migration",
				"The following models have been migrated:\n\n" +
					migratedResources.stream()
						.collect(Collectors.joining("\n")));
		}
		return null;
	}
}
