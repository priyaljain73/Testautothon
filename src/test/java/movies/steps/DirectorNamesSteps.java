package movies.steps;

import static configPackage.Config.*;

import movies.pages.ThreadPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.ThreadInfo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DirectorNamesSteps {



    @Given("^a list of movie name and urls$")
    public void aListOfMovieNameAndUrls() throws Exception {

        System.out.println("current run mode"+runmode);
        Map<String, String> movies = new HashMap<String, String>();
        movies.put("First", "first url");
        movies.put("Second", "second url");
        ThreadInfo threadInfo = new ThreadInfo(movies);


        //Step Class & Functions
        Class cls = ThreadPage.class;
        Object obj = cls.newInstance();
        
        Method m = cls.getDeclaredMethod("method1");
        Method m2 = cls.getDeclaredMethod("method2");
        Method m3 = cls.getDeclaredMethod("method3");


        threadInfo.doMethods(obj, m, m2, m3).startThreads();

    }

    @When("^user tries to compare the director names on wikipedia and imdb$")
    public void userTriesToCompareTheDirectorNamesOnWikipediaAndImdb(){

    }

    @Then("^the director names should match$")
    public void theDirectorNamesShouldMatch() {



    }
}
