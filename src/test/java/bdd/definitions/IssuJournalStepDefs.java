package bdd.definitions;

import bdd.pages.MainPage;
import bdd.pages.IssuSearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IssuJournalStepDefs {

    MainPage mainPage = new MainPage();
    IssuSearchResultPage searchResultPage = new IssuSearchResultPage();

    @Given("Navigate to Main Page")
    public void navigate (){
        mainPage.navigateTo();
    }

    @When("Search for journal {string}")
    public void search(String searchInput){
        mainPage.search(searchInput);
    }

    @Then("Results got specified with text {string}")
    public void validate(String expected){
        searchResultPage.validateResults(expected);
    }

}
