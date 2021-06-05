package bdd.definitions;


import bdd.pages.Task1Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1StepDefs {
    Task1Page task1page = new Task1Page();

    @When("I type destination address {string}")
    public void iTypeDestinationAddress(String address) {
        task1page.typeAddressInDestination(address);
    }

    @And("I click destination button")
    public void iClickDestinationButton() {
        task1page.clickDestinationButton();
    }

    @And("I type stating point {string}")
    public void iTypeStatingPoint(String address) {
        task1page.typeAddressInStartPoin(address);
    }

    @Then("I verify the fastest time is actually fastest from the list")
    public void iVerifyTheFastestTimeIsActuallyFastestFromTheList() {
        task1page.getResults();

    }
}
