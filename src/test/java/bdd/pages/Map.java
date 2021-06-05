package bdd.pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.tools.ant.types.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static bdd.support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class Map extends Page {

    public Map(){
        url = "https://www.google.com/maps";
    }

    @FindBy (xpath = "//button[@id='searchbox-directions']")
    private WebElement createRouteButton;

    @FindBy (xpath = "(//input[@class='tactile-searchbox-input'])[4]")
    private WebElement fromField;

    @FindBy (xpath = "(//input[@class='tactile-searchbox-input'])[5]")
    private WebElement destinationField;

    @FindBy (xpath = "(//button[@class='searchbox-searchbutton'])[3]")
    private WebElement searchRouteButton;

    @FindBy (xpath = "(//div[@class='section-layout'])[2]")
    private WebElement fastestRoutText;


    public void iOpenThePage2(String arg0) {
        getDriver().navigate().to(url);
    }


    public void iClickOnCreateRout2() {
        createRouteButton.click();
    }

    public void iFillOutFieldFrom2(String address1) {
        fromField.click();
        fromField.sendKeys(address1);
    }

    public void iFillOutFieldTo2(String address2) {
        destinationField.click();
        destinationField.sendKeys(address2);
    }

    public void iClickOnSearchRout2() {
        searchRouteButton.click();
    }

    public void iVerifyTheFastestRout2() {
        String routes = fastestRoutText.getText();
        assertThat(routes.contains("Самый быстрый маршрут")).isTrue();
    }

}
