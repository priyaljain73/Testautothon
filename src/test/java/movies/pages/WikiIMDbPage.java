package movies.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JSONObjects;

import java.util.Arrays;
import java.util.List;

import static movies.steps.DirectorNamesSteps.threadInfo;

public class WikiIMDbPage extends PageObject {
    @FindBy(xpath = "//*[contains(text(),'Directed by')]//following-sibling::td/a")
    private By wikiDirectorName;

    @FindBy(xpath = "//*[contains (@href,'imdb')]")
    private By imdbLinkFromWiki;

    @FindBy(xpath = "//*[contains (text(),'Director')]/following-sibling::a")
    private By imdbDirectorName;

    String[] globalDirectorNameResult = null;
    String[] getGlobalDirectorName = null;

    public String[] getWikiDirectorName(String movie, String url) throws Exception {
        WebDriver driver = threadInfo.getDriver(movie);
        List<WebElement> directorNames = driver.findElements(wikiDirectorName);
        String directorNameResult[] = new String[directorNames.size()];

        for (int i = 0; i < directorNames.size(); i++) {
            directorNameResult[i] = directorNames.get(i).getText();
        }
        globalDirectorNameResult = directorNameResult;
        return directorNameResult;
    }

    public String getimdbLinkFromWiki(String movie, String url) throws Exception {
        WebDriver driver = threadInfo.getDriver(movie);
        return driver.findElement(imdbLinkFromWiki).getText();
    }

    public String[] getIMDbDirectorName(String movie, String url) throws Exception {
        WebDriver driver = threadInfo.getDriver(movie);
        driver.findElement(imdbLinkFromWiki).click();
        List<WebElement> directorElements = driver.findElements(imdbDirectorName);
        String[] directorName = new String[directorElements.size()];
        for (int i = 0; i < directorElements.size(); i++) {
            directorName[i] = directorElements.get(i).getText();
        }
        getGlobalDirectorName = directorName;
        return directorName;
    }


    public Boolean assertDirectorNames(String actual, String expected) {

        if (Arrays.equals(globalDirectorNameResult, getGlobalDirectorName))
            return true;
        else
            return false;
    }

}
