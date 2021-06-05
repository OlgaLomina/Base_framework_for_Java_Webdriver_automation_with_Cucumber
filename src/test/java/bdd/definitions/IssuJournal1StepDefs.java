package bdd.definitions;

import bdd.pages.IssuSearchResultPage;
import bdd.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IssuJournal1StepDefs {

    MainPage mainPage = new MainPage();
    IssuSearchResultPage searchResultPage = new IssuSearchResultPage();

    @Given("Navigate to Main Page")
    public void navigate() {

    }

    @When("Search for journal {string}")
    public void search(String searchInput) {

    }

    @Then("Results got specified with text {string}")
    public void validate(String expected) {

    }
}
