package edelta;

import edelta.lib.EdeltaDefaultRuntime;
import edelta.lib.EdeltaEngine;
import edelta.lib.EdeltaRuntime;
import edelta.lib.annotation.EdeltaGenerated;
import edelta.refactorings.lib.EdeltaRefactorings;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class FromV3ToV4 extends EdeltaDefaultRuntime {
  private EdeltaRefactorings refactorings;

  public FromV3ToV4(final EdeltaRuntime other) {
    super(other);
    refactorings = new EdeltaRefactorings(this);
  }

  public void applyMergeAttributes(final EPackage it) {
    final Function<Collection<Object>, Object> _function = (Collection<Object> oldValues) -> {
      final Function1<Object, String> _function_1 = (Object it_1) -> {
        return it_1.toString();
      };
      return IterableExtensions.join(IterableExtensions.<Object, String>map(IterableExtensions.<Object>filterNull(oldValues), _function_1), " ");
    };
    this.refactorings.mergeAttributes(
      "name", 
      Collections.<EAttribute>unmodifiableList(CollectionLiterals.<EAttribute>newArrayList(getEAttribute("persons", "Person", "firstName"), getEAttribute("persons", "Person", "lastName"))), _function);
  }

  @Override
  public void performSanityChecks() throws Exception {
    ensureEPackageIsLoadedByNsURI("persons", "http://edelta/PersonList/v3");
  }

  @Override
  protected void doExecute() throws Exception {
    applyMergeAttributes(getEPackage("persons"));
    getEPackage("persons").setNsURI("http://edelta/PersonList/v4");
  }

  @Override
  public List<String> getMigratedNsURIs() {
    return List.of(
      "http://edelta/PersonList/v3"
    );
  }

  @Override
  public List<String> getMigratedEcorePaths() {
    return List.of(
      "/v3/Persons.ecore"
    );
  }

  @EdeltaGenerated
  public static void main(final String[] args) throws Exception {
    var engine = new EdeltaEngine(FromV3ToV4::new);
    engine.loadEcoreFile("Persons.ecore",
      FromV3ToV4.class.getResourceAsStream("/v3/Persons.ecore"));
    engine.execute();
    engine.save("modified");
  }
}
