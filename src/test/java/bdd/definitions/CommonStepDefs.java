package bdd.definitions;

import io.cucumber.java.en.Given;
import bdd.pages.QuoteForm;

public class CommonStepDefs {

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "quote":
                new QuoteForm().open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }
}
