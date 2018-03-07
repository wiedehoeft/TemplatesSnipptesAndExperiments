import com.google.inject.Guice;
import com.google.inject.Injector;
import model.Adress;
import model.IPrinter;
import model.Person;
import model.PersonModule;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Showcase for using different (C)DI provider in Java SE environment.
 */
public class Main {

  public static void main(String[] args) {
    bootstrapWithGuice();
    bootstrapWithWeld();
    bootstrapWithHk2();
  }

  /**
   * For weld setup,see
   * https://stackoverflow.com/questions/45174989/building-with-intellij-2017-2-out-directory-duplicates-files-in-build-director and
   * https://issues.jboss.org/browse/WELD-2040 and
   * http://docs.jboss.org/weld/reference/latest/en-US/html_single/#_java_se
   */
  private static void bootstrapWithWeld() {
    WeldContainer container = new Weld().initialize();
    Person person = container.select(Person.class).get();
    printPersonDetails(person);
    container.shutdown();
  }

  /**
   * For HK2-setup, see
   * https://javaee.github.io/hk2/inhabitant-generator.html and
   * https://javaee.github.io/hk2/getting-started.html
   */
  private static void bootstrapWithHk2() {

    ServiceLocator serviceLocator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
    IPrinter service = serviceLocator.getService(IPrinter.class);

    service.print("Hello World");

  }

  /**
   * For Guice setup see
   * https://github.com/google/guice/wiki/GettingStarted
   */
  private static void bootstrapWithGuice() {
    Injector injector = Guice.createInjector(new PersonModule());
    Person person = injector.getInstance(Person.class);

    printPersonDetails(person);
  }

  private static void printPersonDetails(Person person) {
    person.setAdress(new Adress(12345, "Rue de la rue"));

    person.print();
  }
}
