package straightWithoutBdd.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.IssuMainJournalPage;

import java.util.List;

public class BadAndGoodSampleTests extends BaseTest {
    // All logic in one place - not separated in Page Object.
    @Test
    public void badSample() {
        driver.get("https://issuu.com/");
        driver.findElement(By.cssSelector("form > div > input")).sendKeys("National Geographic");
        driver.findElement(By.cssSelector("form > div > input")).sendKeys(Keys.ENTER);
        List<WebElement> list = driver.findElements(By.cssSelector("div.sc-15dtij-6.ibabWW > a > h4"));
        for (WebElement e : list) {
            Assert.assertEquals(e.getText(), "Forbes");
        }
    }

    // Test with page object model. We encapsulate\hide the logic in domain specific language
    @Test
    public void withPageObject() {
        String testWord = "National Geographic";

        IssuMainJournalPage mainPage = new IssuMainJournalPage(driver);
        mainPage.open();
        List<String> titles = mainPage.search(testWord).getTitles();

        // Option 1 - Assertions inside tests (more preferable)
        for (String e : titles) {
            boolean isContains = e.contains(testWord);
            Assert.assertTrue(isContains, "Expected: " + testWord + " Actual: " + e);
            System.out.println(e);
        }

        // Option 2 - Assertions incapsulated in test
        mainPage.validateTitles(titles, testWord);
    }
}