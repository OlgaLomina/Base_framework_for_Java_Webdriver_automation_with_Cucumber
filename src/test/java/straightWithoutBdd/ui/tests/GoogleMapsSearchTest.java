package straightWithoutBdd.ui.tests;

import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.MapsRoutePage;
import straightWithoutBdd.ui.pages.MapsSearchPage;

public class GoogleMapsSearchTest extends BaseTest{

    @Test
    public void searchFastestRoute () {
        MapsSearchPage mapsSearchPage = new MapsSearchPage(driver);
        mapsSearchPage.navigateTo();
        MapsRoutePage mapsRoutePage = mapsSearchPage.searchTo();
        mapsRoutePage.searchFrom();
        mapsRoutePage.validateResults();

    }
}
