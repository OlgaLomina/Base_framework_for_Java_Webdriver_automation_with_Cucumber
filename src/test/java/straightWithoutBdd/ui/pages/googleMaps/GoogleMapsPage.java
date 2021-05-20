package straightWithoutBdd.ui.pages.googleMaps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import straightWithoutBdd.ui.pages.BasePage;

import java.util.List;

public class GoogleMapsPage extends BasePage {

    @FindBy(css = "#searchboxinput")
    private WebElement searchBoxInput;

    @FindBy(css = "#searchbox-directions")
    private WebElement directions;

    @FindBy(css = "#sb_ifc51 > input")
    private WebElement from;

    @FindBy(css = "#sb_ifc52 > input")
    private WebElement to;

    @FindBy(xpath = "//*[@id=\"omnibox-directions\"]/div/div[2]//button")
    private List<WebElement> travelMode;

    @FindBy(css = ".section-directions-trip-numbers .section-directions-trip-duration")
    private List<WebElement> tripTime;

    @FindBy(css = "div.section-action-popup-container > button")
    private WebElement sendToPhone;

    public GoogleMapsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleMapsPage selectRoute(String fromLocation, String destination){
        waitForVisible(searchBoxInput);
        click(directions);
        waitForVisible(from);
        from.clear();
        sendKeys(from, fromLocation);
        to.clear();
        sendKeys(to, destination);
        to.sendKeys(Keys.ENTER);
        waitForVisible(sendToPhone);
        return this;
    }

    public String getDefaultFastestRouteTime() {
        travelMode.get(1).click();
        waitForVisible(sendToPhone);
        return tripTime.get(0).getText();
    }

    public String getFastestRouteTimeByCar() {
        travelMode.get(1).click();
        waitUntilContainsAttribute(travelMode.get(1), "aria-checked", "true");
        waitForVisible(sendToPhone);
        return tripTime.get(0).getText();
    }

    public String getFastestRouteTimeByRecommended(){
        travelMode.get(0).click();
        return tripTime.get(0).getText();
    }


}
