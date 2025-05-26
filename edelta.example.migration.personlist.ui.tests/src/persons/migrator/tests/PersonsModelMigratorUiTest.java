package persons.migrator.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import edelta.ui.testutils.EdeltaUiTestUtils;

@RunWith(SWTBotJunit4ClassRunner.class)
public class PersonsModelMigratorUiTest {

	private static SWTWorkbenchBot bot;

	@BeforeClass
	public static void beforeClass() {
		bot = new SWTWorkbenchBot();
		EdeltaUiTestUtils.closeWelcomePage();
		EdeltaUiTestUtils.openProjectExplorer();
	}

	@Before
	public void importProjects() throws Exception {
		// Import the projects needed for the tests
		EdeltaUiTestUtils.importProject("test-projects/edelta.example.personlists");
		EdeltaUiTestUtils.importProject("test-projects/edelta.example.otherpersonlists");
	}

	@AfterClass
	public static void afterClass() {
		bot.resetWorkbench();
	}

	@After
	public void runAfterEveryTest() throws Exception {
		EdeltaUiTestUtils.cleanWorkspace();
	}

	@Test
	public void testToolbarButton() throws Exception {
		bot.toolbarButtonWithTooltip("Migrate Persons Models").click();
		SWTBotShell dialog = bot.shell("Migration").activate();
		// Verify that the dialog contains information
		// that all workspace models have been migrated
		String dialogText = dialog.bot().label(1).getText();
		assertThat(dialogText)
			.contains(
				"The following models have been migrated:",
				"edelta.example.personlists/My.persons",
				"edelta.example.personlists/My2.persons",
				"edelta.example.otherpersonlists/list1/My.persons",
				"edelta.example.otherpersonlists/list2/My2.persons");
		dialog.bot().button("OK").click();
	}

	@Test
	public void testMenu() throws Exception {
		bot.shell().menu().menu("Migration").menu("Migrate Persons Models").click();
		SWTBotShell dialog = bot.shell("Migration").activate();
		// Verify that the dialog contains information
		// that all workspace models have been migrated
		String dialogText = dialog.bot().label(1).getText();
		assertThat(dialogText)
			.contains(
				"The following models have been migrated:",
				"edelta.example.personlists/My.persons",
				"edelta.example.personlists/My2.persons",
				"edelta.example.otherpersonlists/list1/My.persons",
				"edelta.example.otherpersonlists/list2/My2.persons");
		dialog.bot().button("OK").click();
		// Run migration again
		bot.shell().menu().menu("Migration").menu("Migrate Persons Models").click();
		// a subsequent click on the menu should show the dialog again
		// stating that no models have been migrated
		dialog = bot.shell("Migration").activate();
		dialogText = dialog.bot().label(1).getText();
		assertThat(dialogText)
			.contains("No model files to migrate");
		dialog.bot().button("OK").click();
	}

	@Test
	public void testEditor() {
		SWTBotView projectExplorer = bot.viewByTitle("Project Explorer");
		SWTBotTreeItem testProject = projectExplorer.bot().tree().getTreeItem("edelta.example.personlists");
		testProject.expand().getNode("My.persons").select().doubleClick();
		SWTBotShell dialog = bot.shell("Migration").activate();
		// Verify that the dialog contains information
		// that only the project models have been migrated
		String dialogText = dialog.bot().label(1).getText();
		assertThat(dialogText)
			.contains(
				"The following models have been migrated:",
				"edelta.example.personlists/My.persons",
				"edelta.example.personlists/My2.persons")
			.doesNotContain(
				"edelta.example.otherpersonlists/list1/My.persons",
				"edelta.example.otherpersonlists/list2/My2.persons");
		dialog.bot().button("OK").click();
		// Ensure that the EMF editor shows the (migrated model) tree
		bot.activeEditor().bot().tree().expandNode("platform:/resource/edelta.example.personlists/My.persons");
	}

}
