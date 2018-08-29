//package movies.steps;
//
//import TestathonProj.steps.serenity.EndUserSteps;
//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import net.thucydides.core.annotations.Steps;
//
///**
// * @author kumar on 28/08/18
// * @project X-search
// */
//
//
//public class SearchSteps {
//
//  @Steps
//  EndUserSteps anna;
//
//  @Given("^the user is on the google home page$")
//  public void theUserIsOnTheGoogleHomePage() {
//    anna.is_at_google_home_page();
//  }
//
//  @When("^the user searches for '(.*)'$")
//  public void theUserSearchesForSamsung(String keyword){
//    anna.enterSearchTermInGoogle(keyword);
//    anna.startGoogleSearch();
//  }
//
//  @Then("^search results should come up$")
//  public void searchResultsShouldComeUp(){
//    anna.checkTitle();
//  }
//}
