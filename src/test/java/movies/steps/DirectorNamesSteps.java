package movies.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import movies.pages.GoogleSearchPage;
import movies.pages.ThreadPage2;
import utils.ThreadInfo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static configPackage.Config.runmode;

public class DirectorNamesSteps {

    ThreadInfo threadInfo;


    @Given("^a list of movie name and urls$")
    public void aListOfMovieNameAndUrls() throws Exception {

        System.out.println("current run mode" + runmode);
        Map<String, String> movies = new HashMap<String, String>();
        movies.put("First", "first url");
        movies.put("Second", "second url");
        threadInfo = new ThreadInfo(movies);


        //Step Class & Functions
        Class cls = GoogleSearchPage.class;
        Object obj = cls.newInstance();


        Method m = cls.getDeclaredMethod("searchName");


        threadInfo.doMethods(obj, m).startThreads();

    }

    @When("^user tries to compare the director names on wikipedia and imdb$")
    public void userTriesToCompareTheDirectorNamesOnWikipediaAndImdb() throws Exception {

        Class cls = ThreadPage2.class;
        Object obj = cls.newInstance();

        Method m = cls.getDeclaredMethod("method1", null);
        Method m2 = cls.getDeclaredMethod("method2", null);
        Method m3 = cls.getDeclaredMethod("method3", null);

        threadInfo.setNewMethods(obj, m, m2, m3).startThreads();

    }

    @Then("^the director names should match$")
    public void theDirectorNamesShouldMatch() {


    }
}
