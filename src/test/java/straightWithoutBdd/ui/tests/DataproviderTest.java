package straightWithoutBdd.ui.tests;

import bdd.support.Loggable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.dataProvider.Destinations;
import straightWithoutBdd.ui.pages.googleMaps.GoogleMapsPage;
import straightWithoutBdd.ui.pages.googleSearch.GoogleSearchPage;

import java.util.List;

public class DataproviderTest extends BaseTest  {

    /**
     * Dataprovider Showcases
     */


    /**
     * Flow 1: Using DataProvider inside test
     */
    @DataProvider(name = "TestData")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {{"Palo Alto", "San Francisco"},
                        {"Palo Alto", "San Jose"},
                        {"Palo Alto", "Sunnyvale"}};
    }

    @Test(dataProvider = "TestData")
    public void dataproviderUsingParams(String from, String to) {
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.open();
        searchPage.doSearchOf("Google Maps").openFirstGoogleLink();

        GoogleMapsPage googleMapsPage = new GoogleMapsPage(driver);
        String fastestTime = googleMapsPage.selectRoute(from, to).getFastestRouteTimeByCar();

        getLogger().info("Using public transportation Currently from location: "+from+" to "+to+" is: "+fastestTime);
    }


    /**
     * Flow 2: Using Dataprovider Class
     */

    @Test(dataProvider = "Destinations", dataProviderClass = Destinations.class)
    public void dataproviderWithClass(String from, String to) {
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.open();
        searchPage.doSearchOf("Google Maps").openFirstGoogleLink();

        GoogleMapsPage googleMapsPage = new GoogleMapsPage(driver);
        String fastestTime = googleMapsPage.selectRoute(from, to).getFastestRouteTimeByCar();

        getLogger().info("Using public transportation Currently from location: "+from+" to "+to+" is: "+fastestTime);
    }

}
