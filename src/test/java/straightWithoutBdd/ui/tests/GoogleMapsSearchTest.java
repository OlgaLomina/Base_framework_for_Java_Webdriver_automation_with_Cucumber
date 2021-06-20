package straightWithoutBdd.ui.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.MapsRoutePage;
import straightWithoutBdd.ui.pages.MapsSearchPage;

import java.lang.Object;

public class GoogleMapsSearchTest extends BaseTest{

    //Test with POM
    //We encapsulate/hide the logic in domain specific language

    MapsSearchPage mapsSearchPage;

    @DataProvider(name = "TestData")
    public Object[][] getDataProvider(){
        return new Object[][] {
            {"Redmond WA", "San Diego CA"},
            {"Redmond WA", "Las Vegas NV"}
        };
    }

    /*@BeforeTest
    public void before (){
        mapsSearchPage = new MapsSearchPage(driver);
        mapsSearchPage.navigateTo();
    }
    */


    @Test(dataProvider = "TestData")
    public void searchFastestRoute (String destination, String from) {
        //Map<String, String> destinationData = getData("destinationToFrom");
        //String destination = destinationData.get("destinationTo");
        //String from = destinationData.get("destinationFrom");
        //String from = "San Jose";
        //String destination = "San Francisco";

        mapsSearchPage = new MapsSearchPage(driver);
        mapsSearchPage.navigateTo();

        MapsRoutePage mapsRoutePage = mapsSearchPage.searchTo(destination);
        mapsRoutePage.searchFrom(from);
        mapsRoutePage.validateResults();

    }

}
