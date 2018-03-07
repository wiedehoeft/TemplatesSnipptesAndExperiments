package model;

public class Adress {

  private int postalCode;
  private String road;

  public Adress(int postalCode, String road) {
    this.postalCode = postalCode;
    this.road = road;
  }

  @Override
  public String toString() {
    return "model.Adress{" +
            "postalCode=" + postalCode +
            ", road='" + road + '\'' +
            '}';
  }
}
