package straightWithoutBdd.ui.tests.commonInterationsSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.tests.BaseTest;

public class WaitLoader extends BaseTest {


    /**
     * Whiteboard version. If Page Object is not available at a time.
     */
    @Test
    public void checkLoader(){
        driver.get("https://demoqa.com/progress-bar");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#startStopButton"))));
        driver.findElement(By.cssSelector("#startStopButton")).click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("#progressBar > div"), "100%"));


    }
}
