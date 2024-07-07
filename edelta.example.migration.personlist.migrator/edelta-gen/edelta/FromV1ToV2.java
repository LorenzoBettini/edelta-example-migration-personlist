package edelta;

import edelta.lib.EdeltaDefaultRuntime;
import edelta.lib.EdeltaEngine;
import edelta.lib.EdeltaRuntime;
import edelta.lib.annotation.EdeltaGenerated;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

@SuppressWarnings("all")
public class FromV1ToV2 extends EdeltaDefaultRuntime {
  public FromV1ToV2(final EdeltaRuntime other) {
    super(other);
  }

  public void renameAttributes(final EPackage it) {
    getEAttribute("persons", "Person", "firstname").setName("firstName");
    getEAttribute("persons", "Person", "lastname").setName("lastName");
  }

  @Override
  public void performSanityChecks() throws Exception {
    ensureEPackageIsLoadedByNsURI("persons", "http://edelta/PersonList/v1");
  }

  @Override
  protected void doExecute() throws Exception {
    renameAttributes(getEPackage("persons"));
    getEPackage("persons").setNsURI("http://edelta/PersonList/v2");
  }

  @Override
  public List<String> getMigratedNsURIs() {
    return List.of(
      "http://edelta/PersonList/v1"
    );
  }

  @Override
  public List<String> getMigratedEcorePaths() {
    return List.of(
      "/v1/Persons.ecore"
    );
  }

  @EdeltaGenerated
  public static void main(final String[] args) throws Exception {
    var engine = new EdeltaEngine(FromV1ToV2::new);
    engine.loadEcoreFile("Persons.ecore",
      FromV1ToV2.class.getResourceAsStream("/v1/Persons.ecore"));
    engine.execute();
    engine.save("modified");
  }
}
