package bdd.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class Task1Page extends Page{
    public Task1Page(){
        url="https://www.google.com/maps";
    }

    @FindBy (xpath = "//input[@id='searchboxinput']")
    private WebElement destinationPointField;
    @FindBy (xpath = "//button[@id='searchbox-directions']")
    private WebElement searchDestinationButton;
    @FindBy (xpath = "//div[contains(@id,'directions-searchbox-0')]/..//input")
    private WebElement startPointField;
    @FindBy (xpath = "//span[contains(text(), 'min')]")
    private List<WebElement> results;
    @FindBy (xpath = "//*[contains(text(), 'Fastest route')]/../../../..")
    private WebElement fasterRoute;

    public void typeAddressInDestination(String address){
        //TestContext.getWait().until(ExpectedConditions.visibilityOf(destinationPointField));
        destinationPointField.sendKeys(address);
    }
    public void clickDestinationButton(){
        searchDestinationButton.click();
    }
    public void typeAddressInStartPoin(String address){
        startPointField.sendKeys(address);
        startPointField.sendKeys(Keys.ENTER);
    }
    public void getResults () {
            int fasterWay = Integer.MAX_VALUE;
            for (WebElement result : results) {
                int currentWay = Integer.parseInt(result.getText().replace(" min", ""));
                if (currentWay < fasterWay) {
                    fasterWay = currentWay;
                }
            }
            String fasterWayFomMap=fasterRoute.getText();
            assertThat(fasterWayFomMap.contains(fasterWay+ " min"));

    }
}
