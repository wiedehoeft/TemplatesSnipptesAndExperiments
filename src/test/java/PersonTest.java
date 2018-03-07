import model.Adress;
import model.IPrinter;
import model.Person;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Sample test case to check unit testing of components which are injected at runtime.
 */
public class PersonTest {

  @Mock
  private IPrinter printer;

  @Test
  public void testPersonPrinter() throws Exception {

    // Given
    MockitoAnnotations.initMocks(this);
    Person person = new Person(printer);
    person.setAdress(new Adress(12345, "la Rue"));

    //When
    person.print();

    //Then
    verify(printer).print("Initialized with adress: model.Adress{postalCode=12345, road='la Rue'}");
  }
}
