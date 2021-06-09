package bdd.definitions;

import bdd.pages.GoogleMaps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class GMStepDefs {

    GoogleMaps maps = new GoogleMaps();

    @When("I input {string} into search field")
    public void iInputIntoSearchField(String destination) {
        maps.typeDestination(destination);
    }

    @And("I press {string} button")
    public void iPressButton(String button) {
        switch (button) {
            case "Direction":
                maps.clickDirectionButton();
                break;
            default:
                throw new RuntimeException("Unknown button: " + button);
        }
    }

    @And("I input {string} into starting point field")
    public void iInputStringIntoStartingPointField(String startingPoint) {
        maps.typeStartingPoint(startingPoint);
    }

    @Then("I validate {string} in results")
    public void iValidateInResults(String bestRoute) {
        maps.waitDirections();
        assertThat(maps.isRouteExist(bestRoute)).isTrue();
    }

    @And("I confirm that distance equals {int} miles")
    public void iConfirmThatDistanceEqualsMiles(int distance) {
        assertThat(maps.isShortestRoute(distance)).isTrue();
    }
}
