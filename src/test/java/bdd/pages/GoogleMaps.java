package bdd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleMaps extends Page {
    public GoogleMaps() {
        url = "https://www.google.com/maps/";
    }

    @FindBy(id = "searchboxinput")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-value='Directions']")
    private WebElement directionButton;

    @FindBy(xpath = "//input[contains(@aria-label,'tarting point')]")
    private WebElement startingPoint;

    @FindBy(xpath = "//div[@class='section-directions-trip-description']")
    private List<WebElement> routes;

    public void typeDestination(String dest) {
        searchField.sendKeys(dest);
        searchField.sendKeys(Keys.ENTER);
    }

    public void clickDirectionButton() {
        directionButton.click();
    }

    public void typeStartingPoint(String start) {
        startingPoint.sendKeys(start);
        startingPoint.sendKeys(Keys.ENTER);
    }

    public void waitDirections() {
        this.waitForVisible(routes.get(0));
    }

    public boolean isRouteExist(String neededRoute) {
        for (WebElement el : routes) {
            if (el.getText().contains(neededRoute)) {
                return true;
            }
        }
        return false;
    }

    public boolean isShortestRoute(String shortestDistance) {
        return routes.get(0).getText().contains(shortestDistance);
    }
}
