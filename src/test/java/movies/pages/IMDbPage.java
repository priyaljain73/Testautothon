package movies.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class IMDbPage extends PageObject {
    @FindBy(xpath = "//*[contains (text(),'Director:')]/following-sibling::a")
    private WebElementFacade imdbDirectorName;

    public String[] getIMDbDirectorName(){
        String[] strings ={"a","b"};
        return strings;
    }
}
