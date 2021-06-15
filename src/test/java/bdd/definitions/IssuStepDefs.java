package bdd.definitions;

import bdd.pages.IssuPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Locale;

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
    public void verifyResults(String testInput) {
        List<String> titles = issuPage.getResultTitles();
        for (String e: titles){
            String actual = e.toLowerCase();
            String expected = testInput.toLowerCase();
        Assert.assertTrue(actual.contains(expected),
                "Expected contains " + testInput + " , actual result: " + e);
    }
    }
}