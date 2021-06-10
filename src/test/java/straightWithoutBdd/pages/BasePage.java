package straightWithoutBdd.pages;

import utils.Loggable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.logging.Level;

import static utils.TestContext.getDriver;


public class BasePage implements Loggable {
    // fields
    protected String url;

    // constructor
    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    public WebDriverWait getWait() {
        return getWait(10);
    }

    public  WebDriverWait getWait(int timeout) {
        return new WebDriverWait(getDriver(), timeout);
    }

    public Actions getActions() {
        return new Actions(getDriver());
    }

    public JavascriptExecutor getExecutor() {
        return (JavascriptExecutor) getDriver();
    }

    public void refresh() {
        getDriver().navigate().refresh();
    }

    public boolean areErrorsPresent() {
        LogEntries entries = getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : entries) {
            if (entry.getLevel().equals(Level.SEVERE)) {
                return true;
            }
        }
        return false;
    }

    protected WebElement getByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    protected List<WebElement> getAllByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    protected void mouseOver(WebElement element) {
        getActions().moveToElement(element).perform();
    }

    protected void waitForVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForDisappear(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitUntilContainsText(WebElement element) {
        getWait().until(driver -> !element.getText().isEmpty());
    }

    protected void waitUntilContainsSpecificText(WebElement element, String text) {
        getWait().until(driver -> element.getText().contains(text));
    }

    protected void waitUntilContainsAttribute(WebElement element, String attribute, String text) {
        getWait().until(driver -> element.getAttribute(attribute).contains(text));
    }

    protected void waitForClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitToBeSelected(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeSelected(element));
    }

    protected void click(WebElement element) {
        waitForClickable(element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            clickWithJS(element);
        }
    }

    protected void sendKeys(WebElement element, String value) {
        waitForVisible(element);
        element.sendKeys(value);
    }

    protected void clickWithJS(WebElement element) {
        getExecutor().executeScript("arguments[0].click();", element);
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
