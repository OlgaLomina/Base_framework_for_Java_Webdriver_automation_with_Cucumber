package bdd.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;
import static bdd.support.TestContext.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AskStage extends Page {

    public AskStage() {
        url = "http://ask-stage.portnov.com/#/home";
    }

    @FindBy(xpath = "//*[@id='mat-input-0']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='mat-input-1']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[contains(text(),'Sign In')]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class='info']")
    private WebElement userInfo;

    @FindBy(xpath = "//h5[@class='mat-line']")
    private List<WebElement> menuList;

    @FindBy(xpath = "(//div[@class='mat-list-item-content'])[7]")
    private WebElement logOutButton;

    @FindBy(xpath = "//button[@class='mat-button mat-warn']")
    private WebElement logOutDialog;


    public void iOpenThePage() {
        getDriver().navigate().to(url);
    }

    public void iLoginWithCredentials2(String role)throws Exception {

//        Map<String, String> user = getData(role);
//        emailField.sendKeys(user.get("email"));
//        passwordField.sendKeys("password");
//        Thread.sleep(2000);
//        signInButton.click();
//        Thread.sleep(2000);

        emailField.sendKeys("teacher4@gmail.com");
        passwordField.sendKeys("12345Abc");
        signInButton.click();
        Thread.sleep(2000);
    }

    public void iValidateTheUserInfo2() {
        String info = userInfo.getText();
        assertThat(info.contains("Mark Johnson")).isTrue();
        assertThat(info.contains("TEACHER")).isTrue();

    }

    public List<String> iGetListOfMenuItems2() {
        List<String> menuItemList = new ArrayList<String>();
        for (WebElement element : menuList) {
            menuItemList.add(element.getText());
        }
        return menuItemList;
    }

    public void iLogoutFromThePage2() {
        logOutButton.click();
        logOutDialog.click();
        assertThat(signInButton.isDisplayed());
    }

}
