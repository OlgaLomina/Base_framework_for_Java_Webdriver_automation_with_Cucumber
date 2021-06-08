package straightWithoutBdd.ui.tests.commonInterationsSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.tests.BaseTest;

public class Alert extends BaseTest {


    /**
     * Whiteboard version. If Page Object is not available at a time.
     */

    @Test
    public void doubleClickAnAlert(){
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.cssSelector("#dblClkBtn"));
        actions.doubleClick(elementLocator).perform();
        System.out.println(driver.switchTo().alert().getText());

    }
}
