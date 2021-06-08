package bdd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class GoogleMapsBDD extends Page {

    @FindBy(css = "#searchboxinput")
    private WebElement endLoc;

    @FindBy(css="#searchbox-searchbutton")
    private WebElement searchIcon;

    @FindBy(xpath = "//div[contains(text(),'Directions')]")
    private WebElement directionsBtn;

    @FindBy(css="#sb_ifc51 > input")
    private WebElement startLoc;

    @FindBy(xpath = "//span[contains(text(),'min')]")
    private List<WebElement> timeTkn;

    public GoogleMapsBDD(){
        url ="https://www.google.com/maps";
    }

    public void enterEndingLoc(String endingLoc) {
        endLoc.sendKeys(endingLoc);
        searchIcon.click();
    }

    public void clickOnDirections() {
        directionsBtn.click();
    }

    public void enterStartingLoc(String startingLoc) {
        startLoc.sendKeys(startingLoc+ Keys.ENTER);
    }

    public int findTheMinDistance() {
        WebElement timeEle = timeTkn.get(0);
        String timeTxt = timeEle.getText();
        String sTime = timeTxt.substring(0,2);
        int iTime = Integer.parseInt(sTime);
        return iTime;
    }
}
