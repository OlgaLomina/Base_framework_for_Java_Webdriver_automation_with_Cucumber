package straightWithoutBdd.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.pages.IssuMainJournalPage;

import java.util.List;

import static utils.TestContext.getDriver;


public class BadAndGoodSampleTests extends BaseTest {


    /**
     * All logic in one place - not separated in Page Object.
     * It's usually the beginners test
     */

    @Test
    public void badSample() {
        getDriver().get("https://issuu.com/");
        getDriver().findElement(By.cssSelector("form > div > input")).sendKeys("National Geographic");
        getDriver().findElement(By.cssSelector("form > div > input")).sendKeys(Keys.ENTER);
        List<WebElement> list = getDriver().findElements(By.cssSelector("div.sc-15dtij-6.ibabWW > a > h4"));
        for (WebElement e : list) {
            Assert.assertEquals(e.getText(), "National Geographic");
        }
    }

    /**
     * Test with page object model
     * We encapsulate\hide the logic in domain specific language
     */
    @Test
    public void withPageObject() {
        String testWord = "National Geographic";

        IssuMainJournalPage mainPage = new IssuMainJournalPage();
        mainPage.open();
        List<String> titles = mainPage.search(testWord)
                .getTitles();

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