package model;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface IPrinter {

  public void print(String s);
}
