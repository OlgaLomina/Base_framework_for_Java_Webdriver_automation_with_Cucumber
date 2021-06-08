package straightWithoutBdd.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MapsRoutePage extends MapsSearchPage{
    public MapsRoutePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='sb_ifc51']/input")
    private WebElement searchInputLocatorFrom;

    @FindBy(xpath = "//*[@class='section-layout']")
    List<WebElement> titles;

    @FindBy(xpath = "//*[@id='section-directions-trip-title-0']")
    WebElement fastestRouteName;

    @FindBy(xpath = "//span[contains(text(),'Fastest route')]")
    WebElement fasterRoute;

    public List<String> getRoutes(){
        List<WebElement> list = titles;
        List<String> routesSet = new ArrayList<>();
        for (WebElement el: list){
            routesSet.add(el.getText());
        }
        return routesSet;
    }

    public void searchFrom(String beginRoute){
        waitForVisible(searchInputLocatorFrom);
        searchInputLocatorFrom.sendKeys(beginRoute);
        searchInputLocatorFrom.sendKeys(Keys.ENTER);
    }

    public void validateResults(){
        waitForVisible(titles.get(0));
        String faster = "";
        int countRoutes = titles.size();
        if (countRoutes > 0) {
            faster = fastestRouteName.getText();
        }
        String fastWord = "Fastest route";
        boolean isContains = fasterRoute.getText().contains(fastWord);
        Assert.assertTrue(isContains, "Expected: " + fastWord + " Actual: " + fasterRoute.getText());
        System.out.println("Fastest Route is : " + fastestRouteName.getText());
    }

}
