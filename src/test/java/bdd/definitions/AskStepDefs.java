package bdd.definitions;

import bdd.pages.AssessmentControlDashboardPage;
import bdd.pages.AssessmentControlLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class AskStepDefs {
    AssessmentControlLoginPage assessmentControlLoginPage = new AssessmentControlLoginPage();
    AssessmentControlDashboardPage assessmentControlDashboardPage = new AssessmentControlDashboardPage();

    @When("Login with provided {string} credentials")
    public void loginWithProvidedCredentials(String role) {
        assessmentControlLoginPage.typeCredentials(role);
    }

    @Then("Validate the role {string} and name {string}")
    public void validateTheRoleAndName(String role, String name) {
        assertThat(assessmentControlDashboardPage.getTextFormInfo().contains(role));
        assertThat(assessmentControlDashboardPage.getTextFormInfo().contains(name));
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
