package movies.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AssertPage extends PageObject {

    public Boolean assertDirectorNames(String actual,String expected) {

        if(actual.equals(expected))
            return true;
        else
            return false;
    }

}
