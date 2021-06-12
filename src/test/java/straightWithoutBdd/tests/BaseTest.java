package straightWithoutBdd.tests;

import utils.Loggable;
import utils.TestContext;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static utils.TestContext.getConfig;
import static utils.TestContext.getDriver;

public class BaseTest implements Loggable {


    @BeforeTest
    public void setup()  {
        TestContext.initialize();
        TestContext.setTimestamp();
        getDriver().manage().timeouts().pageLoadTimeout(getConfig().pageLoadTimeout, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(getConfig().implicitTimeout, TimeUnit.SECONDS);
        getDriver().manage().deleteAllCookies();


    }


    /**
     * Uncomment if you want browser to close
     */
//    @AfterTest
//    public void closeDriver() {
//        getDriver().quit();
//    }


}