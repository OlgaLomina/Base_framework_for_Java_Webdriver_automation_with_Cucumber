package bdd.definitions;

import bdd.pages.AskLogin;
import bdd.pages.GoogleMaps;
import io.cucumber.java.en.Given;
import bdd.pages.QuoteForm;

public class CommonStepDefs {

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "quote":
                new QuoteForm().open();
                break;
            case "Google Maps":
                new GoogleMaps().open();
                break;
            case "ask-stage":
                new AskLogin().open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }
}
