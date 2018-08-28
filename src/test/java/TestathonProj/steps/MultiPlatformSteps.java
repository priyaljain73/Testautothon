package TestathonProj.steps;

import TestathonProj.api.TestApi;
import TestathonProj.steps.serenity.EndUserSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * @author kumar on 28/08/18
 * @project X-search
 */
public class MultiPlatformSteps {


  @Steps
  EndUserSteps endUserSteps;

  TestApi testApi = new TestApi();

  String title ;

  @Given("google returns result for samsung")
  public void googReturnsResultForTerm(){
    endUserSteps.is_at_google_home_page();
    endUserSteps.enterSearchTermInGoogle("samsung");
    endUserSteps.startGoogleSearch();
    endUserSteps.checkTitle();
    title = endUserSteps.getNumberofResults();
  }


  @When("^user runs dummy api$")
  public void userRunsDummyApi(){
    System.out.println("----title--"+title);
    if(title!=null|| !title.isEmpty()){
      String response = testApi.prepareRequest();
      System.out.println("-----response----"+response);
    }
  }

  @Then("^data is passed to different env$")
  public void dataIsPassedToDifferentEnv(){

  }
}
