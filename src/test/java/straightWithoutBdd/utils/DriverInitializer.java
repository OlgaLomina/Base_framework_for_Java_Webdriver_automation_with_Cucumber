package straightWithoutBdd.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverInitializer {

    public static WebDriver setBrowser(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        else if ("firefox".equalsIgnoreCase(browser)) {
            return new FirefoxDriver();
        } else if ("safari".equalsIgnoreCase(browser)) {
            return new SafariDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            return new EdgeDriver();
        }
        return null;
    }
}
