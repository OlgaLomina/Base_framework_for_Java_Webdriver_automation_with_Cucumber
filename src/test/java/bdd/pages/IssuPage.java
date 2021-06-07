package bdd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import static utils.TestContext.getDriver;

public class IssuPage extends Page {


    public IssuPage() {
        url = "https://issuu.com/";
    }

    @FindBy(css = "div.ih-Search-overlayInner > form > div > input")
    private WebElement searchInput;

    @FindBy(css = "div.MetaBar__SearchTerm > p")
    private WebElement resultsBar;

    @FindBy(css = "div.sc-15dtij-6.ibabWW > a > h4")
    private List<WebElement> titles;

    public void searchWithText(String searchText) {
        waitForVisible(searchInput);
        sendKeys(searchInput, searchText);
        searchInput.sendKeys(Keys.ENTER);

    }

    public List<String> getResultTitles() {
        waitForVisible(resultsBar);
        waitForVisible(titles.get(0));
        List<String> list = new ArrayList<>();
        for (WebElement e : titles) {
            list.add(e.getText());
        }
        return list;
    }
}