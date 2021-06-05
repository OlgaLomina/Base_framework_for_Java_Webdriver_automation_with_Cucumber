package bdd.definitions;

import bdd.pages.Map;
import bdd.pages.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static bdd.support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Stepdefs extends Page {

//WORKING VARIANT WITHOUT USING PAGE

//    @Given("I open the {string} page")
//    public void iOpenThePage(String arg0) {
//        getDriver().navigate().to("https://www.google.com/maps");
//    }
//
//    @When("I click on create rout")
//    public void iClickOnCreateRout() {
//        getDriver().findElement(By.xpath("//button[@id='searchbox-directions']")).click();
//    }
//
//    @Then("I fill out field From")
//    public void iFillOutFieldFrom() {
//          getDriver().findElement(By.xpath("(//input[@class='tactile-searchbox-input'])[4]")).click();
//          getDriver().findElement(By.xpath("(//input[@class='tactile-searchbox-input'])[4]")).sendKeys("San Francisco California");
//    }
//    @Then("I fill out field To")
//      public void iFillOutFieldTo() {
//           getDriver().findElement(By.xpath("(//input[@class='tactile-searchbox-input'])[5]")).click();
//           getDriver().findElement(By.xpath("(//input[@class='tactile-searchbox-input'])[5]")).sendKeys("San Jose California");
//    }
//
//    @Then("I click on search rout")
//    public void iClickOnSearchRout() {
//        getDriver().findElement(By.xpath("(//button[@class='searchbox-searchbutton'])[3]")).click();
//    }
//
//    @Then("I verify the cheapest rout")
//    public void iVerifyTheCheapestRout() {
//         assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'Самый быстрый маршрут')]")).isDisplayed());
//    }



//WORKING VARIANT WITH USING PAGE

    Map map = new Map();

    @Given("I open the {string} page")
    public void iOpenThePage(String url) {
        map.iOpenThePage2(url);
    }

    @When("I click on create rout")
    public void iClickOnCreateRout() {
       map.iClickOnCreateRout2();
    }

    @Then("I fill out field From")
    public void iFillOutFieldFrom() {
        map.iFillOutFieldFrom2("San Francisco California");
    }
    @Then("I fill out field To")
    public void iFillOutFieldTo() {
        map.iFillOutFieldTo2("San Joce California");
    }

    @Then("I click on search rout")
    public void iClickOnSearchRout() {
       map.iClickOnSearchRout2();
    }

    @Then("I verify the fastest rout")
    public void iVerifyTheCheapestRout() {
        map.iVerifyTheFastestRout2();
        }


    }






