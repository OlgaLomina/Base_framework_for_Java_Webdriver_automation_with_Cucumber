package straightWithoutBdd.ui.tests;

import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.MapsRoutePage;
import straightWithoutBdd.ui.pages.MapsSearchPage;

public class GoogleMapsSearchTest extends BaseTest{

    @Test
    public void searchFastestRoute () {
        String from = "San Jose";
        String destination = "San Francisco";

        MapsSearchPage mapsSearchPage = new MapsSearchPage(driver);
        mapsSearchPage.navigateTo();
        MapsRoutePage mapsRoutePage = mapsSearchPage.searchTo(destination);
        mapsRoutePage.searchFrom(from);
        mapsRoutePage.validateResults();

    }
}
