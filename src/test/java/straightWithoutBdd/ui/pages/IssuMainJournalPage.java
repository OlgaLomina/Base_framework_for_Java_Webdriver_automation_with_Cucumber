package straightWithoutBdd.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class IssuMainJournalPage extends BasePage {

    @FindBy(css = "form > div > input")
    WebElement searchInputLocator;

    @FindBy(css = "div.sc-15dtij-6.ibabWW > a > h4")
    List<WebElement> titles;

    public IssuMainJournalPage(WebDriver driver) {
        super(driver);
        url = "https://issuu.com/";
    }

    public IssuSearchResultPage search(String searchInput){
        searchInputLocator.sendKeys(searchInput);
        searchInputLocator.sendKeys(Keys.ENTER);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER);



        return new IssuSearchResultPage(driver);
    }

    public void validateTitles(List<String> titles, String expectedWord){
        for(String e : titles){
            Assert.assertTrue(e.contains(expectedWord));
        }
    }


}
