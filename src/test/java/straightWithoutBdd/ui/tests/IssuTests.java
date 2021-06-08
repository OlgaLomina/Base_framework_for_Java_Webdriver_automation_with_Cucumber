package straightWithoutBdd.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.IssuMainJournalPage;

import java.util.List;


public class IssuTests extends BaseTest {

    /**
     * Test with page object model
     * We encapsulate\hide the logic in domain specific language
     */
    @Test
    public void withPageObject() {
        String testWord = "National Geographic";

        IssuMainJournalPage mainPage = new IssuMainJournalPage(driver);
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