package bdd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static bdd.support.TestContext.getDriver;

public class MapsMainPage extends Page {

    @FindBy(xpath = "//*[@id='searchboxinput']")
    WebElement searchInputLocatorTo;

    @FindBy(xpath = "//*[@id='searchbox-directions']")
    WebElement searchboxDirections;

    @FindBy(xpath = "//*[@id='sb_ifc51']/input")
    WebElement searchInputLocatorFrom;

    public void navigateTo(){
        getDriver().get("https://www.google.com/maps/");
        waitForVisible(searchInputLocatorTo);
    }

    public void searchFromTo(String fromRoute, String toRoute){
        searchInputLocatorTo.sendKeys(toRoute);
        searchboxDirections.click();
        searchInputLocatorFrom.sendKeys(fromRoute);
        searchInputLocatorFrom.sendKeys(Keys.ENTER);
    }
}
