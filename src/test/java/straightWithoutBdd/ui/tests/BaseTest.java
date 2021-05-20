package straightWithoutBdd.ui.tests;

import bdd.support.Loggable;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static straightWithoutBdd.ui.utils.DriverInitializer.setBrowser;

public class BaseTest implements Loggable {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = setBrowser("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testSample() {
        driver.get("https://www.google.com/");
    }
}