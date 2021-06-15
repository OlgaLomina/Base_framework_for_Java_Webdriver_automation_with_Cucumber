package straightWithoutBdd.tests.commonInterationsSamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.tests.BaseTest;

import java.util.List;

import static utils.TestContext.getDriver;

public class RadioAndCheckboxes extends BaseTest {

    @Test
    public void dropdown(){
        getLogger().info("Print");
        getDriver().get("http://demo.guru99.com/test/radio.html");
        List<WebElement> element = getDriver().findElements(By.xpath("//input[@type='radio']"));

        // is radio button is selected
        element.stream().filter(e-> e.getAttribute("value").contains("Option 1")).findFirst().get().click();
        Assert.assertTrue(isOptionSelected(element, "Option 1"));

    }

    // Using Java Streams library - very useful for filtration, mapping
    public boolean isOptionSelected(List<WebElement> elements, String selection){
        return elements.stream().filter(e->
                e.getAttribute("value").contains(selection)).findFirst().get().isSelected();
    }
}
