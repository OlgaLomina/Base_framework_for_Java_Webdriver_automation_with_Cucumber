package straightWithoutBdd.ui.tests.commonInterationsSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.tests.BaseTest;

import java.util.List;

public class Scroll_DragAndDrop extends BaseTest {

    /**
     * Whiteboard version. If Page Object is not available at a time.
     * Thread sleeps only for time saving - should not be in real test
     */

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://material.angular.io/cdk/drag-drop/overview");

        // sleep used just to save time. Thread sleeps only for time saving - should not be in real test
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"cdk-drop-list-6\"]/div"));

        WebElement sourceLocator = elements.get(4);
        WebElement destinationLocator = elements.get(0);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elements.get(0));

        //Creating object of Actions class to build composite actions
        Actions builder = new Actions(driver);

        //Building a drag and drop action
        Action dragAndDrop = builder.clickAndHold(sourceLocator)
                .moveToElement(destinationLocator)
                .release(destinationLocator)
                .build();

        //Performing the drag and drop action
        dragAndDrop.perform();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"cdk-drop-list-6\"]/div"), "Episode V - The Empire Strikes Back"));

        List<WebElement> elementsAfter = driver.findElements(By.xpath("//*[@id=\"cdk-drop-list-6\"]/div"));

        System.out.println("Order After");
        for (WebElement element : elementsAfter){
            System.out.println(element.getText());
        }
    }

}