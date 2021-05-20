package straightWithoutBdd.ui.pages.googleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import straightWithoutBdd.ui.pages.BasePage;

import java.util.List;

public class GoogleResultPage extends BasePage {

    /**
     * Showcase of Chain Logic between pages
     * @param driver
     */

    @FindBy(css = "#logo > img")
    WebElement logo;

    @FindBy(css = "#search h3.LC20lb")
    List<WebElement> searchResultsHeaders;

    @FindBy (css = "#topabar #resultStats")
    WebElement resultsQuantity;

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstHeaderFromSearchPage(){
        return searchResultsHeaders.get(0).getText();
    }

    public void openFirstGoogleLink (){
        waitForVisible(logo);
        searchResultsHeaders.get(0).click();
    }
}