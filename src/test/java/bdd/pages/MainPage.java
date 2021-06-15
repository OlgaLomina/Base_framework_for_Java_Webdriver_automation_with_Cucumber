package bdd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.TestContext.getDriver;


public class MainPage extends Page {

    @FindBy(css = "form > div > input")
    WebElement searchInputLocator;


    public void navigateTo(){
        getDriver().get("https://issuu.com/");
        waitForVisible(searchInputLocator);
    }

    public void search(String param){
        searchInputLocator.sendKeys(param);
        searchInputLocator.sendKeys(Keys.ENTER);
    }
}