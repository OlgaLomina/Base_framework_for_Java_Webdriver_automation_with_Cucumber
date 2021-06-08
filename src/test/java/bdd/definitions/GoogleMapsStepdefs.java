package bdd.definitions;

import bdd.pages.GoogleMapsBDD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.apache.logging.log4j.LogManager.getLogger;

public class GoogleMapsStepdefs {
    @Given("Navigate to the {string} maps landing page")
    public void navigateToTheMapsLandingPage(String arg0) {
        new GoogleMapsBDD().open();

    }

    @When("I enter {string} as the destination")
    public void iEnterAsTheDestination(String endingLoc){
        new GoogleMapsBDD().enterEndingLoc(endingLoc);
    }

    @And("I find directions from {string}")
    public void iFindDirectionsFrom(String startingLoc) {
        new GoogleMapsBDD().clickOnDirections();
        new GoogleMapsBDD().enterStartingLoc(startingLoc);
    }

    @Then("I will find the shortest distance")
    public void iWillFindTheShortestDistance() {
        int minTime = new GoogleMapsBDD().findTheMinDistance();
        getLogger().info("Min time is: "+minTime);
    }
}
