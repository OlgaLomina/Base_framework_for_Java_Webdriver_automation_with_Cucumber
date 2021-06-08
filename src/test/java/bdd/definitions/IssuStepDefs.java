package bdd.definitions;

import bdd.pages.IssuPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

import static utils.TestContext.getDriver;

public class IssuStepDefs {
    IssuPage issuPage = new IssuPage();

    @Given("Navigate to main Page")
    public void navigateToMainPage() {
        issuPage.open();
    }

    @When("Search for the word {string}")
    public void searchFor(String input) {
        issuPage.searchWithText(input);
    }

    @Then("Verify that result set contains {string}")
    public void iVerifyViaRESTNewPositionIsInTheList(String testInput) {
        List<String> titles = issuPage.getResultTitles();
        for (String e: titles){
        Assert.assertTrue(e.contains(testInput),
                "Expected contains " + testInput + " , actual result: " + e);
    }
    }


}