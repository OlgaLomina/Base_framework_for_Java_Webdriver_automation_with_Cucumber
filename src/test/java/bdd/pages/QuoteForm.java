package bdd.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.assertj.core.api.Assertions.assertThat;
import static bdd.support.TestContext.getDriver;

public class QuoteForm extends Page {

    public QuoteForm() {
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement name;

    // name dialog
    @FindBy(name = "firstName")
    private WebElement firstName;
    @FindBy(name = "middleName")
    private WebElement middleName;
    @FindBy(name = "lastName")
    private WebElement lastName;
    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacy;

    @FindBy(id = "formSubmit")
    private WebElement submit;

    // additional info iFrame
    @FindBy(name = "additionalInfo")
    private WebElement additionalInfoFrame;
    @FindBy(id = "contactPersonName")
    private WebElement contactPersonName;
    @FindBy(id = "contactPersonPhone")
    private WebElement contactPersonPhone;

    @FindBy(id = "username-error")
    private WebElement usernameError;
    @FindBy(id = "email-error")
    private WebElement emailError;

    // dynamic field
    private WebElement errorElement(String fieldName) {
        return getByXpath("//label[@id='" + fieldName + "-error']");
    }

    // methods

    public String getErrorFieldText(String fieldName) {
        return errorElement(fieldName).getText();
    }

    public boolean isErrorFieldDisplayed(String fieldName) {
        boolean isDisplayed;
        try {
            isDisplayed = errorElement(fieldName).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public String getUsernameErrorText() {
        return usernameError.getText();
    }

    public String getEmailErrorText() {
        return emailError.getText();
    }

    public void fillContactInfo(String nameValue, String phoneValue) {
        getDriver().switchTo().frame(additionalInfoFrame);
        contactPersonName.sendKeys(nameValue);
        contactPersonPhone.sendKeys(phoneValue);
        getDriver().switchTo().defaultContent();
    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillBothPasswords(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
        assertThat(name.getAttribute("value")).isEqualTo(firstNameValue + " " + lastNameValue);
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
        assertThat(name.getAttribute("value")).isEqualTo(firstNameValue + " " + middleNameValue + " " + lastNameValue);
    }

    public void checkWithPrivacyPolicy() {
        if (!privacy.isSelected()) {
            privacy.click();
        }
    }

    public void uncheckPrivacyPolicy() {
        if (privacy.isSelected()) {
            privacy.click();
        }
    }

    public void submit() {
        submit.click();
    }
}