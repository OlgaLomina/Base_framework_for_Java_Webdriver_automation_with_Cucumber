package straightWithoutBdd.ui.tests.commonInterationsSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.tests.BaseTest;

import static utils.TestContext.getDriver;

public class WaitLoader extends BaseTest {


    /**
     * Whiteboard version. If Page Object is not available at a time.
     */
    @Test
    public void checkLoader(){
        getDriver().get("https://demoqa.com/progress-bar");
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector("#startStopButton"))));
        getDriver().findElement(By.cssSelector("#startStopButton")).click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("#progressBar > div"), "100%"));


    }
}
