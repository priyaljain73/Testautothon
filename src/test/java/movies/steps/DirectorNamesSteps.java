package movies.steps;

import configPackage.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import movies.pages.GoogleSearchPage;
import movies.pages.WikiIMDbPage;
import movies.stepImpl.DirectorNameStepsImpl;
import org.junit.Assert;
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

        HashMap<String, String> movies = ImportData.generateData();

        //-------

       // HashMap<String, String> movies = new HashMap<>();
       // movies.put("The Avengers","https://en.wikipedia.org/wiki/The_Avengers_(2012_film)");
         //      movies.put("The Godfather","https://en.wikipedia.org/wiki/The_Godfather");

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

        for (int i = 0; i < threadInfo.getDo().size(); i++) {
            System.out.println("Movie : " + threadInfo.getDo().get(i).moviename);
            System.out.println("Wiki url : " + threadInfo.getDo().get(i).wikirurls);
            System.out.println("IMDB url : " + threadInfo.getDo().get(i).imdburl);

            int imdbDirectorNamesSize = threadInfo.getDo().get(i).imdbdirectornames.length;
            int wikiDirectorNamesSize = threadInfo.getDo().get(i).wikidirectornames.length;
            int expectedMatch = (imdbDirectorNamesSize > wikiDirectorNamesSize) ? imdbDirectorNamesSize : wikiDirectorNamesSize;
            int count = 0;

            for (int j = 0; j < imdbDirectorNamesSize; j++) {
                for (int k = 0; k < wikiDirectorNamesSize; k++) {
                    if (threadInfo.getDo().get(i).imdbdirectornames[j].equalsIgnoreCase(threadInfo.getDo().get(i).wikidirectornames[k]))
                    {

                        System.out.println("Expected: "+threadInfo.getDo().get(i).imdbdirectornames[j] );
                        System.out.println("Actual: "+threadInfo.getDo().get(i).wikidirectornames[j] );
                        count++;
                        break;
                    }
                }
            }

            Assert.assertEquals(count, expectedMatch);

            System.out.println("Expected Match Count: "+expectedMatch );
            System.out.println("Actual Match Count: "+ count );


        }
    }}
