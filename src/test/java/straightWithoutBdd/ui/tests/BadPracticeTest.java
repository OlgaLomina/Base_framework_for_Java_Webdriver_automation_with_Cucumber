package straightWithoutBdd.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.dataProvider.Destinations;
import java.util.List;

public class BadPracticeTest extends BaseTest {


    /**
     * Anti-Pattern Showcase: no decoupling, no atomization, code duplications, no domain specific language
     * Instead we should use Page Object Model
     * DON'T DO LIKE THIS
     */

    @Test()
    public void badPracticeTest() {
        String from = "Palo Alto";
        String to = "Sunnyvale";

        driver.get("https://www.google.com");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("Google Maps");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
        List<WebElement> t = driver.findElements(By.cssSelector("#search h3.LC20lb"));
        t.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchboxinput")));
        driver.findElement(By.cssSelector("#searchbox-directions")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sb_ifc51 > input")));
        driver.findElement(By.cssSelector("#sb_ifc51 > input")).clear();
        driver.findElement(By.cssSelector("#sb_ifc51 > input")).sendKeys(from);
        driver.findElement(By.cssSelector("#sb_ifc52 > input")).sendKeys(to);
        driver.findElement(By.cssSelector("#sb_ifc52 > input")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("div.travel-mode.selected.directions-selected-travel-mode > button > img")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.section-directions-trip-numbers > div")));
        WebElement webElements = driver.findElement(By.cssSelector("div.section-directions-trip-numbers > div"));
        System.out.println("Using public transportation Currently from location: "+from+" to location: "+to+" is: "+webElements.getText());
    }

}
