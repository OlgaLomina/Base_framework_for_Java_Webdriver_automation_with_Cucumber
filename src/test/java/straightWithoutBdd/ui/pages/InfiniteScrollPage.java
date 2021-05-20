package straightWithoutBdd.ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfiniteScrollPage extends BasePage{

    // Random Footer Value
    @FindBy(css = "username")
    private WebElement footer;


    public InfiniteScrollPage(WebDriver driver) {
        super(driver);
        url = "http://the-internet.herokuapp.com/infinite_scroll";
    }

    public void scrollToElement(){
        while(!isElementDisplayed(footer)){
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }
    }
}