package movies.steps;

import configPackage.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import movies.pages.GoogleSearchPage;
import movies.pages.WikiIMDbPage;
import movies.stepImpl.DirectorNameStepsImpl;
import utils.Do;
import utils.ImportData;
import utils.ThreadInfo;

import java.lang.reflect.Method;
import java.util.HashMap;

public class DirectorNamesSteps {


    public static ThreadInfo threadInfo;
    public String runmode = Config.runmode;


    DirectorNameStepsImpl directorNameStepsimpl = new DirectorNameStepsImpl();

    public DirectorNamesSteps() throws IllegalAccessException, InstantiationException {
    }

    @Given("^a list of movie name and urls$")
    public void aListOfMovieNameAndUrls() throws Exception {

       // HashMap<String, String> movies = ImportData.generateData();

        //-------

        HashMap<String, String> movies = new HashMap<>();
        movies.put("The Avengers","https://en.wikipedia.org/wiki/The_Avengers_(2012_film)");
               movies.put("The Godfather","https://en.wikipedia.org/wiki/The_Godfather");


        //--------



        System.out.println("current run mode" + runmode);

        threadInfo = new ThreadInfo(movies);

        Class[] params = new Class[2];
        params[0] = String.class;
        params[1] = String.class;

        //Step Class & Functions
        Class cls = WikiIMDbPage.class;
        Object obj = cls.newInstance();


        Method m = cls.getDeclaredMethod("extractDataFromWiki", params);

        System.out.println(System.currentTimeMillis());
        threadInfo.doMethods(obj, m).startThreads();
        System.out.println(System.currentTimeMillis());
        threadInfo.waitForThreadsToComplete();
        System.out.println(System.currentTimeMillis());


    }

    @When("^user tries to extract the director names on wikipedia and imdb$")
    public void userTriesToCompareTheDirectorNamesOnWikipediaAndImdb() throws Exception {


        Class[] params = new Class[2];
        params[0] = String.class;
        params[1] = String.class;

        //Step Class & Functions
        Class cls = WikiIMDbPage.class;
        Object obj = cls.newInstance();

        Method m = cls.getDeclaredMethod("extractDataFromImdb", params);

        threadInfo.setNewMethods(obj, m).startThreads();
        threadInfo.waitForThreadsToComplete();

    }

    @Then("^the director names should match$")
    public void theDirectorNamesShouldMatch() throws Exception {

        threadInfo.quitAllDrivers();

        for(int i = 0; i < threadInfo.getDo().size(); i++)
        {
            System.out.println("Movie : " + threadInfo.getDo().get(i).moviename);
            System.out.println("Wiki url : " + threadInfo.getDo().get(i).wikirurls);
            System.out.println("IMDB url : " + threadInfo.getDo().get(i).imdburl);

            for(int j = 0; j < threadInfo.getDo().get(i).imdbdirectornames.length; j++)
            {
                System.out.println("IMDB Director : " + threadInfo.getDo().get(i).imdbdirectornames[j]);
            }

            for(int j = 0; j < threadInfo.getDo().get(i).wikidirectornames.length; j++)
            {
                System.out.println("Wiki Director : " + threadInfo.getDo().get(i).wikidirectornames[j]);
            }
        }

//        Class[] params = new Class[2];
//        params[0] = String.class;
//        params[1] = String.class;
//
//        Method m = cls1.getDeclaredMethod("assertKeyValues", params);
//
//        threadInfo.setNewMethods(obj, m).startThreads();
//        threadInfo.waitForThreadsToComplete();

    }
}
