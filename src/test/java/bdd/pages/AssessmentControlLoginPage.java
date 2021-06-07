package bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    private String password="12345Abc";
    private String login="teacher3@gmail.com";

    public void loginAsATeacher (){
        emailField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }





}
