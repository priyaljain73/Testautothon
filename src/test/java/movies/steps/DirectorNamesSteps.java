package movies.steps;

import configPackage.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import movies.pages.GoogleSearchPage;
import movies.pages.WikiIMDbPage;
import movies.stepImpl.DirectorNameStepsImpl;
import utils.ImportData;
import utils.ThreadInfo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class DirectorNamesSteps {


    public static ThreadInfo threadInfo;
    public String runmode = Config.runmode;
    Class cls1 = WikiIMDbPage.class;
    Object obj = cls1.newInstance();


    DirectorNameStepsImpl directorNameStepsimpl = new DirectorNameStepsImpl();

    public DirectorNamesSteps() throws IllegalAccessException, InstantiationException {
    }

    @Given("^a list of movie name and urls$")
    public void aListOfMovieNameAndUrls() throws Exception {

        HashMap<String, String> movies = ImportData.generateData();
        System.out.println("current run mode" + runmode);

        threadInfo = new ThreadInfo(movies);

        Class[] params = new Class[2];
        params[0] = String.class;
        params[1] = String.class;

        //Step Class & Functions
        Class cls = GoogleSearchPage.class;
        Object obj = cls.newInstance();


        Method m = cls.getDeclaredMethod("searchName", params);


        threadInfo.doMethods(obj, m).startThreads();
        threadInfo.waitForThreadsToComplete();

    }

    @When("^user tries to extract the director names on wikipedia and imdb$")
    public void userTriesToCompareTheDirectorNamesOnWikipediaAndImdb() throws Exception {


        Class[] params = new Class[2];
        params[0] = String.class;
        params[1] = String.class;

        Method m = cls1.getDeclaredMethod("getWikiDirectorName", params);
        Method m2 = cls1.getDeclaredMethod("getIMDbDirectorName", params);

        threadInfo.setNewMethods(obj, m, m2).startThreads();
        threadInfo.waitForThreadsToComplete();

    }

    @Then("^the director names should match$")
    public void theDirectorNamesShouldMatch() throws Exception {

        Class[] params = new Class[2];
        params[0] = String.class;
        params[1] = String.class;

        Method m = cls1.getDeclaredMethod("assertDirectorNames", params);

        threadInfo.setNewMethods(obj, m).startThreads();
        threadInfo.waitForThreadsToComplete();

    }
}
