package bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class RoutesPage extends Page {

    @FindBy(xpath = "//*[@class='section-layout']")
    List<WebElement> titles;

    @FindBy(xpath = "//*[@id='section-directions-trip-title-0']")
    WebElement fastestRouteName;

    @FindBy(xpath = "//span[contains(text(),'Fastest route')]")
    WebElement fasterRoute;

    public void validateResults(String fastWord){
        waitForVisible(titles.get(0));
        String faster = "";
        int countRoutes = titles.size();
        if (countRoutes > 0) {
            faster = fastestRouteName.getText();
        }
        boolean isContains = fasterRoute.getText().contains(fastWord);
        Assert.assertTrue(isContains, "Expected: " + fastWord + " Actual: " + fasterRoute.getText());
        System.out.println("Fastest Route is : " + fastestRouteName.getText());
    }
}
