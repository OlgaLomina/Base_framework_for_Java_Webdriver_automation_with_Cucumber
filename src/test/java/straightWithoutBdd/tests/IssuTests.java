package straightWithoutBdd.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import straightWithoutBdd.pages.IssuMainJournalPage;

import java.util.List;
import java.util.Map;

import static utils.TestContext.getData;


public class IssuTests extends BaseTest {

    /**
     * Test with page object model
     * We encapsulate\hide the logic in domain specific language
     */

    @DataProvider(name = "TestData")
    public Object[][] getDataProvider() {
        Map<String, String> searchData = getData("testfile");

        return new Object[][]{
                {"National Geographic", "National Geographic"},
                {"Forbes", "Should fail"}
        };
    }

    IssuMainJournalPage mainPage;


    @Test(dataProvider = "TestData")
    public void withPageObject(String searchInput, String expected) {
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