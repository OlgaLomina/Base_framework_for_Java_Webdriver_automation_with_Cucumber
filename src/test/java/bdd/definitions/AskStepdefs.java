package bdd.definitions;

import bdd.pages.AskDashboard;
import bdd.pages.AskLogin;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Arrays;

public class AskStepdefs {

    AskLogin askLogin = new AskLogin();
    AskDashboard askDashboard = new AskDashboard();

    @When("I login with {string} and {string}")
    public void iLoginWithAnd(String email, String password) {
        askLogin.login(email, password);
    }

    @Then("I validate dashboard info")
    public void iValidateDashboardInfo() {
        Assert.assertEquals(askDashboard.getMenuItems(),
                Arrays.asList("Home", "Submissions", "Assignments", "Quizzes", "User's Management", "Settings"));
        Assert.assertEquals(askDashboard.getUserName(), "Diana Brown");
        Assert.assertEquals(askDashboard.getUserRole(), "TEACHER");
    }

    @Then("I logout")
    public void iLogout() {
        askDashboard.logOut();
    }

    @When("I login From File")
    public void iLoginFromFile() {
        askLogin.login();
    }
}
