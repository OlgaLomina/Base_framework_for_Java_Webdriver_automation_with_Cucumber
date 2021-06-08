package straightWithoutBdd.ui.tests;

import bdd.pages.IssuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.IssuMainJournalPage;

import java.util.List;
import java.util.Map;

import static utils.TestContext.getData;


public class IssuTests extends BaseTest {

    /**
     * Test with page object model
     * We encapsulate\hide the logic in domain specific language
     */



    @Test
    public void withPageObject() {
        IssuMainJournalPage mainPage = new IssuMainJournalPage();
        String testWord = "National Geographic";
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

    @DataProvider(name = "TestData")
    public Object[][] getDataProvider() {
        return new Object[][]{
                {"National Geographic", "National Geographic"},
                {"Forbes", "FORBES"}
        };
    }
    IssuMainJournalPage mainPage;
    @Test(dataProvider = "TestData")
    public void withPageObject(String searchInput, String expected) {
        Map<String, String> searchData = getData("issu");
        String testWord = searchInput;
        mainPage = new IssuMainJournalPage();
        mainPage.open();
        List<String> titles = mainPage.search(testWord)
                .getTitles();
        // Option 1 - Assertions inside tests (more preferable)
        for (String e : titles) {
            boolean isContains = e.contains(expected);
            Assert.assertTrue(isContains, "Expected: " + testWord + " Actual: " + e);
            System.out.println(e);
        }
        // Option 2 - Assertions incapsulated in test
        mainPage.validateTitles(titles, testWord);
    }
}