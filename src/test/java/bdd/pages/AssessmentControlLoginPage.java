package bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Map;
import static bdd.support.TestContext.getData;

public class AssessmentControlLoginPage extends Page{

    public AssessmentControlLoginPage() {
        url = "http://ask-stage.portnov.com/#/home";
    }

    @FindBy(xpath = "//*[@placeholder='Email *']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@placeholder='Password *']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public void typeCredentials (String role){
        Map<String, String> customer=getData(role);
        emailField.sendKeys(customer.get("email"));
        passwordField.sendKeys(customer.get("password"));
        submitButton.click();
    }
}
