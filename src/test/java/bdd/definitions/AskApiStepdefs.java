package bdd.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AskApiStepdefs {
    @Given("Create api request for sign_in")
    public void createApiRequestForSign_in() {
        System.out.println();
    }


    @When("Call sign_in by post method")
    public void callSign_inByPostMethod() {
    }

    @Then("Validate sign-in api response")
    public void validateSignInApiResponse() {
    }
}
