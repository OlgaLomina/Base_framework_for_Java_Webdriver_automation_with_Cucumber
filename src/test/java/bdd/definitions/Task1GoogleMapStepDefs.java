package bdd.definitions;

import bdd.pages.GoogleMap;
import bdd.pages.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Task1GoogleMapStepDefs extends Page {

    GoogleMap map = new GoogleMap();

    @Given("I open the {string} page")
    public void iOpenThePage(String url) {
        map.iOpenThePage2(url);
    }

    @When("I click on create route")
    public void iClickOnCreateRoute() {
       map.iClickOnCreateRout2();
    }

    @Then("I fill out field From {string}")
    public void iFillOutFieldFrom(String address1) {
        map.iFillOutFieldFrom2("San Francisco California");
    }

    @Then("I fill out field To {string}")
    public void iFillOutFieldTo(String address2) {
        map.iFillOutFieldTo2("San Jose California");
    }

    @Then("I click on search route")
    public void iClickOnSearchRoute() {
       map.iClickOnSearchRout2();
    }

    @Then("I verify the fastest route")
    public void iVerifyTheCheapestRoute() {
        map.iVerifyTheFastestRout2();
        }

    }

