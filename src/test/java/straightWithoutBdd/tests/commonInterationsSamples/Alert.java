package straightWithoutBdd.tests.commonInterationsSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import straightWithoutBdd.tests.BaseTest;

import static utils.TestContext.getDriver;

public class Alert extends BaseTest {


    /**
     * Whiteboard version. If Page Object is not available at a time.
     */

    @Test
    public void doubleClickAnAlert(){
        getDriver().get("https://www.testandquiz.com/selenium/testing.html");
        Actions actions = new Actions(getDriver());
        WebElement elementLocator = getDriver().findElement(By.cssSelector("#dblClkBtn"));
        actions.doubleClick(elementLocator).perform();
        System.out.println(getDriver().switchTo().alert().getText());

    }
}
