package bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AskDashboardPage extends Page {

    @FindBy(xpath = "//*@class='info'")
    private WebElement userInfo;

    @FindBy(xpath = "//header[1]/div[1]/h3[1]")
    private WebElement name;

    @FindBy(xpath = "//mat-list/header/div/p")
    private WebElement role;

    //@FindBy(css = "div > div.mat-list-text > h5")
    @FindBy(css = "ac-side-menu > mat-list > a")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//mat-list/mat-list-item/div")
    private WebElement logOutButton;

    public String getUserName(){
        return name.getText();
    }

    public String getUserRole(){
        return role.getText();
    }

    public List<String> getMenuItems(){
        List<String> menuItemsList = new ArrayList<>();
        for (WebElement el: menuItems){
            menuItemsList.add(el.getText());
        }
        return menuItemsList;
    }

    public void logOut(){
        logOutButton.click();
    }

}
