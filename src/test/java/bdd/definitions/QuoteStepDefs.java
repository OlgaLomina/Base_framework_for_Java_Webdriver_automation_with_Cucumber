package bdd.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import bdd.pages.QuoteForm;
import bdd.pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static bdd.support.TestContext.getData;

public class QuoteStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResult result = new QuoteResult();

    @When("I fill out required fields")
    public void iFillOutRequiredFieldsForOop() {
        Map<String, String> user = getData("user");
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillBothPasswords(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.checkWithPrivacyPolicy();
    }

    @And("I submit the form")
    public void iSubmitTheFormOop() {
        form.submit();
    }

    @Then("I verify required fields")
    public void iVerifyRequiredFieldsForOop() {
        Map<String, String> user = getData("user");
        String resultText = result.getResultText();
        assertThat(resultText).contains(user.get("username"));
        assertThat(resultText).contains(user.get("email"));
        assertThat(resultText).contains(user.get("firstName"));
        assertThat(resultText).contains(user.get("lastName"));
        assertThat(result.isAgreedToPrivacyPolicy()).isTrue();
        assertThat(result.getPasswordText()).isEqualTo("[entered]");
    }
}
