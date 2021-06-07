package straightWithoutBdd.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//import static bdd.support.TestContext.getDriver;


public class MapsSearchPage extends BasePage{

    public MapsSearchPage(WebDriver driver) {
        super(driver);
        url = "https://www.google.com/maps/";
    }

    private String endRoute = "Redmond WA";

    @FindBy(xpath = "//*[@id='searchboxinput']")
    private WebElement searchInputLocatorTo;

    @FindBy(xpath = "//*[@id='searchbox-directions']")
    private WebElement searchboxDirections;

    public void navigateTo(){
        driver.get(url);
        waitForVisible(searchInputLocatorTo);
    }

    public MapsRoutePage searchTo(){
        searchInputLocatorTo.sendKeys(endRoute);
        searchboxDirections.click();
        return new MapsRoutePage(driver);
    }

}
