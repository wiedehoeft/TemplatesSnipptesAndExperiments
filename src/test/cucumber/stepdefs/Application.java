package stepdefs;

public class Application {

  private final Frontend frontend;

  public Application(Frontend frontend) {
    this.frontend = frontend;
  }

  public void newMovie(Command command) {
    frontend.print(command);
  }
}
