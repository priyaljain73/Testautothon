package movies.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static movies.steps.DirectorNamesSteps.threadInfo;

public class WikiIMDbPage extends PageObject {
    @FindBy(xpath = "//*[contains(text(),'Directed by')]//following-sibling::td/a")
    private By wikiDirectorName;

    @FindBy(xpath = "//*[contains (@href,'imdb')]")
    private WebElementFacade imdbLinkFromWiki;

    @FindBy(xpath = "//*[contains (text(),'Director')]/following-sibling::a")
    private By imdbDirectorName;

    public String[] getWikiDirectorName(String movie) throws Exception {
        List<WebElement> directorNames = threadInfo.getDriver(movie).findElements(wikiDirectorName);
        String directorNameResult[] = new String[directorNames.size()];

        for (int i = 0; i < directorNames.size(); i++) {
            directorNameResult[i] = directorNames.get(i).getText();
        }
        return directorNameResult;
    }

    public void getToIMDbPage() {
        imdbLinkFromWiki.click();
    }

    public String getimdbLinkFromWiki() {
        return imdbLinkFromWiki.getText();
    }

    public String[] getIMDbDirectorName(String movie) throws Exception {
        List<WebElement> directorElements = threadInfo.getDriver(movie).findElements(imdbDirectorName);
        String[] directorName = new String[directorElements.size()];
        for (int i = 0; i < directorElements.size(); i++) {
            directorName[i] = directorElements.get(i).getText();
        }
        return directorName;
    }
}
