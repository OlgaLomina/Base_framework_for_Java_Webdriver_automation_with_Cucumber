package bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AssessmentControlDashboardPage extends Page {

    @FindBy(xpath = "//div[@class='info']")
    private WebElement infoField;

    @FindBy(xpath = " //h5[@class='mat-line']")
    private List<WebElement> menuFields;

    @FindBy(xpath = "//h5[@class='mat-line'][contains(text(), 'Log Out')]")
    private WebElement logOutButton;

    public String getTextFormInfo(){
        return infoField.getText();
    }
    public List<String> getMenuText (){
        waitForClickable(logOutButton);
        List<String> menuItems=new ArrayList<>();
        for (WebElement menuField : menuFields){
            menuItems.add(menuField.getText());
        }
        return  menuItems;
    }
    public void clickLogOut (){
        logOutButton.click();
    }
}
