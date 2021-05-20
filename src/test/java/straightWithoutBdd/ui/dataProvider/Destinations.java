package straightWithoutBdd.ui.dataProvider;

import org.testng.annotations.DataProvider;

public class Destinations {

    @DataProvider(name = "Destinations")
    public static Object[][] destinations() {
        return new Object[][] {
                {"Newark", "Hoboken"},
                {"Newport", "Times Square"},
                {"San Francisco", "San Jose"},
                {"Boston", "New York"}
        };
    }
}
