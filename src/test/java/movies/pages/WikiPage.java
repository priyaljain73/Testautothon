package movies.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WikiPage extends PageObject {
    @FindBy(xpath = "//*[contains(text(),'Directed by')]//following-sibling::td/a")
    private By wikiDirectorName;

    @FindBy(xpath = "//*[contains (@href,'imdb')]")
    private WebElementFacade imdbLinkFromWiki;


    public String[] getDirectorName() {
        List<WebElement> directorNames = getDriver().findElements(wikiDirectorName);
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
}
