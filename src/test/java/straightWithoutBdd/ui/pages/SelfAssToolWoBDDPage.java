package straightWithoutBdd.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelfAssToolWoBDDPage extends BasePage{

    @FindBy(css="#mat-input-0")
    private WebElement emailId;

    @FindBy(css="#mat-input-1")
    private WebElement passwd;

    public SelfAssToolWoBDDPage(){
        url="http://ask-stage.portnov.com/#/login";
    }

    public void login(String userId, String password) {
        emailId.sendKeys(userId);
        passwd.sendKeys(password);
    }
}
