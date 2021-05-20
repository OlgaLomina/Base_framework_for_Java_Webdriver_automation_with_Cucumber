package straightWithoutBdd.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoaderPage extends BasePage{

    @FindBy(css = "#progressBar > div")
    private WebElement progressBar;

    @FindBy(css = "#startStopButton")
    private WebElement startStopButton;

    @FindBy(css = "#resetButton")
    private WebElement resetButton;

    public LoaderPage(WebDriver driver) {
        super(driver);
        url = "https://demoqa.com/progress-bar";
    }

    public void checkProgressBar(){
        waitForVisible(startStopButton);
        click(startStopButton);
        waitUntilContainsSpecificText(progressBar, "100%");
        isElementDisplayed(resetButton);
    }
}