package bdd.definitions;

import bdd.pages.AskStage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class Task2AskStepDefs {
    AskStage askStage = new AskStage();

    @Given("I open the page")
    public void iOpenThePage() {
        askStage.iOpenThePage();
    }

    @When("I login with credentials as {string}")
    public void iLoginWithCredentials(String role){
        askStage.iLoginWithCredentials2(role);
    }

    @Then("I validate the user {string} and {string}")
    public void iValidateTheUserAnd(String arg0, String arg1){
        askStage.iValidateTheUserInfo2("Iryna Valadimirova", "TEACHER");
    }

    @And("I validate list of menu items")
    public void iValidateListOfMenuItems() {
        Object[] menu = askStage.iGetListOfMenuItems2().toArray();
        Assert.assertEquals(askStage.iGetListOfMenuItems2(),
                Arrays.asList("Home","Submissions","Assignments","Quizzes", "User's Management", "Settings", "Log Out"));
    }

    @Then("I logout from the page")
    public void iLogoutFromThePage() {
        askStage.iLogoutFromThePage2();
    }



}
