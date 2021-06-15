package bdd.pages;


import bdd.support.Loggable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static bdd.support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;


public class GoogleMap extends Page implements Loggable {

    String  distance = "";

    public GoogleMap(){
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

     @FindBy (xpath = "//span[contains(text(),'мин.')]")
    private List<WebElement> routesList;

    @FindBy (xpath = "//div[@id='section-directions-trip-0']")
    private WebElement firstRoute;


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

    public void iClickOnSearchRout2() { searchRouteButton.click();
    }



    public String  findFastestRoute(int maxTries) throws InterruptedException{
        double fastestRoute = Double.MAX_VALUE;
            for (WebElement route : routesList) {
                double currentRoute = Double.parseDouble(route.getText().replace("мин", ""));
                if (currentRoute < fastestRoute) {
                    fastestRoute = currentRoute;
                }
            }

        distance = String.valueOf(fastestRoute);
        getLogger().info("Fastest route:  " + distance);
        return distance;

    }
    public void iVerifyTheFastestRout2() {
        String firstRouteText = firstRoute.getText();
        assertThat(firstRouteText.contains(distance)).isTrue();
        assertThat(firstRouteText.contains("Самый быстрый маршрут")).isTrue();
    }

}
