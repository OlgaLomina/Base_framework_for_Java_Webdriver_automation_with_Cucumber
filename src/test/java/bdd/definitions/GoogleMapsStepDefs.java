package bdd.definitions;

import bdd.pages.MainPage;
import bdd.pages.MapsMainPage;
import bdd.pages.RoutesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleMapsStepDefs {

    MapsMainPage mapsMainPage = new MapsMainPage();
    RoutesPage routesPage = new RoutesPage();

    @When("I fill out Destinations From {string} To {string}")
    public void iFillOutDestinationsFromTo(String distFrom, String distTo) {
        mapsMainPage.searchFromTo(distFrom, distTo);
    }

    @Then("I verify the {string}")
    public void iVerifyThe(String route) {
        routesPage.validateResults(route);
    }
}
