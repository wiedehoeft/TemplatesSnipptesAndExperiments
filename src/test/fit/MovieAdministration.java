import fit.ColumnFixture;
import fit.Fixture;

public class MovieAdministration extends Fixture {

  private int movieNumber;
  private String movieTitle;
  private String priceCategory;

  public void newMovie() {

  }

  public int movieNumber() {
    return 1;
  }

  public void movieTitle(String title) {
    movieTitle = title;
  }

  public void priceCategory(String category) {
    priceCategory = category;
  }
}
