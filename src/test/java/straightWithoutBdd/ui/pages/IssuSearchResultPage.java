package straightWithoutBdd.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IssuSearchResultPage extends IssuMainJournalPage {
    public IssuSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getTitles(){
        List<WebElement> list = driver.findElements(By.cssSelector("div.sc-15dtij-6.ibabWW > a > h4"));
        List<String> resultSet = new ArrayList<>();
        for (WebElement e : list){
            resultSet.add(e.getText());
        }
        return resultSet;
    }
}