package edelta;

import edelta.lib.EdeltaDefaultRuntime;
import edelta.lib.EdeltaEngine;
import edelta.lib.EdeltaRuntime;
import edelta.lib.annotation.EdeltaGenerated;
import edelta.refactorings.lib.EdeltaRefactorings;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

@SuppressWarnings("all")
public class FromV2ToV3 extends EdeltaDefaultRuntime {
  private EdeltaRefactorings refactorings;

  public FromV2ToV3(final EdeltaRuntime other) {
    super(other);
    refactorings = new EdeltaRefactorings(this);
  }

  public void applyEnumToSubclasses(final EPackage it) {
    this.refactorings.enumToSubclasses(getEAttribute("persons", "Person", "gender"));
  }

  @Override
  public void performSanityChecks() throws Exception {
    ensureEPackageIsLoadedByNsURI("persons", "http://edelta/PersonList/v2");
  }

  @Override
  protected void doExecute() throws Exception {
    applyEnumToSubclasses(getEPackage("persons"));
    getEPackage("persons").setNsURI("http://edelta/PersonList/v3");
  }

  @Override
  public List<String> getMigratedNsURIs() {
    return List.of(
      "http://edelta/PersonList/v2"
    );
  }

  @Override
  public List<String> getMigratedEcorePaths() {
    return List.of(
      "/v2/Persons.ecore"
    );
  }

  @EdeltaGenerated
  public static void main(final String[] args) throws Exception {
    var engine = new EdeltaEngine(FromV2ToV3::new);
    engine.loadEcoreFile("Persons.ecore",
      FromV2ToV3.class.getResourceAsStream("/v2/Persons.ecore"));
    engine.execute();
    engine.save("modified");
  }
}
