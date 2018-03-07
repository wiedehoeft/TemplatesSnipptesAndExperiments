package model;

import com.google.inject.AbstractModule;

public class PersonModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(IPrinter.class).to(AdressPrinter.class);
  }
}
