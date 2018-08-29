package movies.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.Arrays;
import java.util.List;

import static movies.steps.DirectorNamesSteps.threadInfo;

public class WikiIMDbPage extends PageObject {


    String keyToVerify;


    @FindBy(xpath = "//*[contains(text(),'Directed by')]//following-sibling::td/a")
    private By wikiDirectorName;

    @FindBy(xpath = "//*[contains (@href,'imdb')]")
    private By imdbLinkFromWiki;

    @FindBy(xpath = "//*[contains (text(),'Director')]/following-sibling::a")
    private By imdbDirectorName;

    private String[] globalDirectorNameResult = null;
    private String[] getGlobalDirectorName = null;

    public void extractDataFromWiki(String movie, String url) throws Exception {

        if(!url.equalsIgnoreCase("No url found"))
        {
            threadInfo.getDo(movie).getDriver().get(url);

            WebDriver driver = threadInfo.getDriver(movie);
            List<WebElement> directorNames = driver.findElements(By.xpath("//*[contains(text(),'Directed by')]//following-sibling::td/a"));
            String directorNameResult[] = new String[directorNames.size()];

            for (int i = 0; i < directorNames.size(); i++) {
                directorNameResult[i] = directorNames.get(i).getText();
            }
            threadInfo.getDo(movie).wikidirectornames = directorNameResult;
            threadInfo.getDo(movie).imdburl= driver.findElement(By.xpath("//a[text() = 'IMDb']//preceding-sibling::a[1]")).getAttribute("href");
        }
        else
        {
            String[] directorNameResult = {"Not Available"};
            threadInfo.getDo(movie).wikidirectornames = directorNameResult;
            threadInfo.getDo(movie).imdburl = "IMDb Movie URL Not Found";
        }

    }

    public void extractDataFromImdb(String movie, String url) throws Exception {

        if(!url.equalsIgnoreCase("No url found")) {
            WebDriver driver = threadInfo.getDriver(movie);
            driver.findElement(By.xpath("//a[text() = 'IMDb']//preceding-sibling::a[1]")).click();
            List<WebElement> directorElements = driver.findElements(By.xpath("//*[contains (text(),'Director')]/following-sibling::a"));
            String[] directorName = new String[directorElements.size()];
            for (int i = 0; i < directorElements.size(); i++) {
                directorName[i] = directorElements.get(i).getText();
            }
            threadInfo.getDo(movie).imdbdirectornames = directorName;
        }
        else
        {
            String[] directorName = {"Not Available"};
            threadInfo.getDo(movie).imdbdirectornames = directorName;
        }
    }


    public Boolean assertKeyValues(String actual, String expected) {

        return Arrays.equals(globalDirectorNameResult, getGlobalDirectorName);
    }

}
