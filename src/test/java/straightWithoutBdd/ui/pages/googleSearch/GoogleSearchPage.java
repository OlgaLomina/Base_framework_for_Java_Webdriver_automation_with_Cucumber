package straightWithoutBdd.ui.pages.googleSearch;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import straightWithoutBdd.ui.pages.BasePage;

public class GoogleSearchPage extends BasePage {

    /**
     * Showcase of Chain Logic between pages
     * @param driver
     */

    @FindBy(css = "div.a4bIc > input")
    private WebElement searchInput;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        url = "https://www.google.com/";
    }

    public GoogleResultPage doSearchOf(String searchText){
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchInput.sendKeys(Keys.ENTER);
        return new GoogleResultPage(driver);
    }

}
