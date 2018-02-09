package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.fail;
import static org.assertj.core.api.Assertions.assertThat;


public class InventoryStepDefs implements En {

  private Application applicationUnderTest;

  @Mock
  private Command command;

  @Mock
  private Frontend console;


  public InventoryStepDefs() {

    Before(() -> {
      MockitoAnnotations.initMocks(this);
    });

    Given("^Movie administration is started$", () -> {
      applicationUnderTest = new Application(console);
    });

    When("^User presses new movie button$", () -> {
      applicationUnderTest.newMovie(command);
    });

    Then("^User has to enter movie title$", () -> {
      Mockito.verify(console).print(command);
    });

    And("^Movie number should be (\\d+)$", (Integer arg0) -> {
      assertThat(arg0).isEqualTo(1);
    });

    And("^User has to enter price category$", () -> {
      Mockito.verify(console).print(command);
    });
  }
}
