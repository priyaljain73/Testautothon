package movies.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IMDbPage extends PageObject {
    @FindBy(xpath = "//*[contains (text(),'Director')]/following-sibling::a")
    private By imdbDirectorName;

    public String[] getIMDbDirectorName() {
        List<WebElement> directorElements = getDriver().findElements(imdbDirectorName);
        String[] directorName = new String[directorElements.size()];
        for (int i = 0; i < directorElements.size(); i++) {
            directorName[i] = directorElements.get(i).getText();
        }
        return directorName;
    }
}
