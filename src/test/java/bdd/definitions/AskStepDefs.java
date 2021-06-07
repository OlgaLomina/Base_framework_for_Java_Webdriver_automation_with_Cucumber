package bdd.definitions;

import bdd.pages.AssessmentControlDashboardPage;
import bdd.pages.AssessmentControlLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import  java.util.ArrayList;
import java.util.Arrays;
import  java.util.List;




import static org.assertj.core.api.Assertions.assertThat;

public class AskStepDefs {
    AssessmentControlLoginPage assessmentControlLoginPage = new AssessmentControlLoginPage();
    AssessmentControlDashboardPage assessmentControlDashboardPage = new AssessmentControlDashboardPage();

    @When("Login with provided credentials")
    public void loginWithProvidedCredentials() {
        assessmentControlLoginPage.loginAsATeacher();
    }

    @Then("Validate the role and name")
    public void validateTheRoleAndName() {
        assertThat(assessmentControlDashboardPage.getTextFormInfo().contains("TEACHER"));
        assertThat(assessmentControlDashboardPage.getTextFormInfo().contains("Olga Wilson"));


    }

    @And("Validate list of menu items")
    public void validateListOfMenuItems() {
        Assert.assertEquals(assessmentControlDashboardPage.getMenuText(),
                Arrays.asList("Home", "Submissions", "Assignments", "Quizzes", "User's Management", "Settings", "Log Out"));

    }

    @And("Logout from the webpage")
    public void logoutFromTheWebpage() {
        assessmentControlDashboardPage.clickLogOut();

    }
}
