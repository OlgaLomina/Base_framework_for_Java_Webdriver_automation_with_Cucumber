package bdd.definitions;

import bdd.pages.AskDashboardPage;
import bdd.pages.AskLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Arrays;

public class AskStepDefs {

//     3) Validate the role and name
//    4) Validate list of menu items
//    5) Logout from the webpage

    AskLoginPage askLogin = new AskLoginPage();
    AskDashboardPage askDashBoard = new AskDashboardPage();

    @When("I login with {string} and {string}")
    public void iLoginWithAnd(String email, String password) {
        askLogin.login(email, password);
    }

    @Then("I validate dashboard info {string} {string}")
    public void iValidateDashboardInfo(String userName, String roleName) {
        Assert.assertEquals(askDashBoard.getSidebarTitles(), Arrays.asList("Home", "Submissions", "Assignments", "Quizzes", "User's Management", "Settings", "Log Out"));

        Assert.assertEquals(askDashBoard.getUserName(), userName);
        Assert.assertEquals(askDashBoard.getUserRole(), roleName);

    }
}
