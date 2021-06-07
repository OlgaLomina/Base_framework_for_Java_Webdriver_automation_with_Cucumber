package bdd.definitions;

import bdd.pages.AssessmentControlLoginPage;
import io.cucumber.java.en.Given;
import bdd.pages.QuoteForm;
//import bdd.pages.Task1Page;

public class CommonStepDefs {

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "quote":
                new QuoteForm().open();
                break;
//            case "googlemaps":
//                new Task1Page().open();
//                break;
            case "Assessment Control":
                new AssessmentControlLoginPage().open();
                break;
            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }
}
