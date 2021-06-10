package straightWithoutBdd.ui.tests;

import bdd.support.Loggable;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static straightWithoutBdd.utils.DriverInitializer.setBrowser;

public class BaseTest implements Loggable {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = setBrowser("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }

//    @Test
//    public void testSample() {
//        driver.get("https://www.google.com/");
//    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

}