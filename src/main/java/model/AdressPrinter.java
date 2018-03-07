package model;

import org.jvnet.hk2.annotations.Service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Service
public class AdressPrinter implements IPrinter {

  @Override
  public void print(String s) {
    System.out.println(s);
  }
}
