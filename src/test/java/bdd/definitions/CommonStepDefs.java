package bdd.definitions;

import bdd.pages.AskLoginPage;
import bdd.pages.MapsMainPage;
import io.cucumber.java.en.Given;
import bdd.pages.QuoteForm;

public class CommonStepDefs {

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "quote":
                new QuoteForm().open();
                break;
            case "googlemaps":
                new MapsMainPage().navigateTo();
                break;
            case "stage":
                new AskLoginPage().open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }
}
