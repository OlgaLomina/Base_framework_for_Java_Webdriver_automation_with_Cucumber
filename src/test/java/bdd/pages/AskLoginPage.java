package bdd.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AskLoginPage extends Page {

    public AskLoginPage() {
        url = "http://ask-stage.portnov.com/#/login";
    }

    @FindBy(xpath = "//*[@id=\"mat-input-0\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"mat-input-1\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    private WebElement submit;

    public void login(String login, String passw) {
        email.sendKeys(login);
        password.sendKeys(passw);
        submit.click();
    }

}
