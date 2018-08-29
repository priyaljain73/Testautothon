package movies.steps;

import configPackage.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import movies.pages.ThreadPage;
import movies.pages.ThreadPage2;
import movies.stepImpl.DirectorNameStepsImpl;
import net.serenitybdd.screenplay.actions.Switch;
import org.springframework.beans.factory.annotation.Autowired;
import movies.pages.GoogleSearchPage;
import movies.pages.WikiIMDbPage;
import utils.ThreadInfo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static configPackage.Config.runmode;

public class DirectorNamesSteps {

    public static ThreadInfo threadInfo;
    public String runmode=Config.runmode;

    DirectorNameStepsImpl directorNameStepsimpl=new DirectorNameStepsImpl();

    @Given("^a list of movie name and urls$")
    public void aListOfMovieNameAndUrls() throws Exception {



        System.out.println("current run mode"+runmode);
        Map<String, String> movies = new HashMap<String, String>();
        movies.put("First", "first url");
        movies.put("Second", "second url");
        threadInfo = new ThreadInfo(movies);

        Class[] params = new Class[2];
        params[0]= String.class;
        params[1]= String.class;

        //Step Class & Functions
        Class cls = GoogleSearchPage.class;
        Object obj = cls.newInstance();


        Method m = cls.getDeclaredMethod("searchName",params);


        threadInfo.doMethods(obj, m).startThreads();

    }

    @When("^user tries to extract the director names on wikipedia and imdb$")
    public void userTriesToCompareTheDirectorNamesOnWikipediaAndImdb() throws Exception {

        switch (runmode) {
            case "api":
                directorNameStepsimpl.checkapi();

                case "ui":
                Class cls = WikiIMDbPage.class;
                Object obj = cls.newInstance();

                Method m = cls.getDeclaredMethod("method1", null);
                Method m2 = cls.getDeclaredMethod("method2", null);
                Method m3 = cls.getDeclaredMethod("method3", null);

                threadInfo.setNewMethods(obj, m, m2, m3).startThreads();

        }
    }
    @Then("^the director names should match$")
    public void theDirectorNamesShouldMatch() {


    }
}
