package straightWithoutBdd.tests.commonInterationsSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import straightWithoutBdd.tests.BaseTest;

import static utils.TestContext.getDriver;

public class Dropdown extends BaseTest {


    @Test
    public void dropdown(){
        getDriver().get("https://www.testandquiz.com/selenium/testing.html");
        WebElement selector = getDriver().findElement(By.cssSelector("#testingDropdown"));
        Select select = new Select(selector);
        getLogger().info(select.getFirstSelectedOption().getText());
        select.selectByValue("Manual");
        getLogger().info("After test " + select.getFirstSelectedOption().getText());


    }
}
