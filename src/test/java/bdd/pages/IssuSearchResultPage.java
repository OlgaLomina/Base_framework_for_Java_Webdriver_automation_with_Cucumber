package bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class IssuSearchResultPage extends Page {

    @FindBy(css = "div.sc-15dtij-6.ibabWW > a > h4")
    List<WebElement> titles;

    public void validateResults(String testWord){

        waitForVisible(titles.get(0));
        List<String> resultSet = new ArrayList<>();
        for (WebElement e : titles){
            resultSet.add(e.getText());
        }
        for(String e : resultSet){
            boolean isContains = e.contains(testWord);
            Assert.assertTrue(isContains, "Expected: " + testWord + " Actual: " + e);
            System.out.println(e);
        }
    }
}
