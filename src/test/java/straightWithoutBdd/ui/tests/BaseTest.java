package straightWithoutBdd.ui.tests;

import bdd.support.Loggable;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static straightWithoutBdd.utils.DriverInitializer.setBrowser;

public class BaseTest implements Loggable {
    public WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = setBrowser("chrome");
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }

    @Test
    public void testSample() {
        driver.get("https://www.google.com/");
    }


    /**
     * Uncomment if you want browser to close
     */
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }


}