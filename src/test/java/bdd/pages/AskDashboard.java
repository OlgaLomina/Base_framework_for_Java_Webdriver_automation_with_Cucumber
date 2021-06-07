package bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AskDashboard extends Page {

    public AskDashboard() {
        url = "http://ask-stage.portnov.com/#/home";
    }

    @FindBy (xpath = "//*[@class='info']/h3")
    private WebElement userName;

    @FindBy (xpath = "//*[@class='info']/p")
    private WebElement userRole;

    @FindBy (css = "ac-side-menu > mat-list > a")
    private List<WebElement> menuItems;

    @FindBy (css = "mat-list-item > div > div.mat-list-text > h5")
    private WebElement logOutButton;

    @FindBy (css = "button.mat-button.mat-warn > span")
    private WebElement confirmLogOutButton;

    public String getUserName() {
        return userName.getText();
    }

    public String getUserRole() {
        return userRole.getText();
    }

    public List<String> getMenuItems() {
        List<String> menuItemsList = new ArrayList<>();
        for (WebElement element : menuItems) {
            menuItemsList.add(element.getText());
        }
        return menuItemsList;
    }

    public void logOut() {
        logOutButton.click();
        confirmLogOutButton.click();
    }
}
