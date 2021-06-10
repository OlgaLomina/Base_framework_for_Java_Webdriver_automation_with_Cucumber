package bdd.definitions;

import bdd.pages.AssessmentControlLoginPage;
import bdd.pages.Task1Page;
import io.cucumber.java.en.Given;
import bdd.pages.QuoteForm;

public class CommonStepDefs {

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "quote":
                new QuoteForm().open();
                break;
            case "Assessment Control":
                new AssessmentControlLoginPage().open();
                break;
            case "googlemaps":
                new Task1Page().open();
                break;

            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }
}
