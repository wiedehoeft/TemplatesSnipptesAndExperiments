package model;

import org.jvnet.hk2.annotations.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Service
public class Person {

  private Adress adress;
  private IPrinter printer;

  @Inject
  public Person(IPrinter printer) {
    this.adress = adress;
    this.printer = printer;
  }

  public void setAdress(Adress adress) {
    this.adress = adress;
  }

  public void print() {
    printer.print("Initialized with adress: " + adress);
  }
}
