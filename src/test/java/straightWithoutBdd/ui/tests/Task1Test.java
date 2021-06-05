package straightWithoutBdd.ui.tests;

import org.testng.annotations.Test;

import straightWithoutBdd.ui.pages.GoogleMaps;

public class Task1Test extends BaseTest {
    GoogleMaps googleMaps=new GoogleMaps(driver);
    @Test
    public void fasterWay() {
        driver.get("https://www.google.com/maps");// doesn't work too

        //googleMaps.open(); doesn't work (in example from class we open web page from BDD package
        //for BadAndGoodSampleTest we open browser mainPage(bdd pack) with extend Page(bdd pack) with implement Loggable
        //don't know how to make it works without bdd
        String addressDestination="San Francisco, California";
        String addressStartPoint="San Jose, California";
        googleMaps.typeAddressInDestination(addressDestination);
        googleMaps.clickDestinationButton();
        googleMaps.typeAddressInStartPoin(addressStartPoint);
        googleMaps.getResults();
    }
}
