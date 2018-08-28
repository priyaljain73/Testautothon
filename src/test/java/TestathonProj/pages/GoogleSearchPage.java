package TestathonProj.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author kumar on 28/08/18
 * @project X-search
 */

  @DefaultUrl("https://www.google.com/")
  public class GoogleSearchPage extends PageObject {

    @FindBy(id="lst-ib")
    private WebElementFacade searchTextBox;

    @FindBy(name="btnK")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//*[@id=\"resultStats\"]")
    private WebElementFacade searchResultCount;

    public void enter_keywords(String keyword) {
      getDriver().manage().window().fullscreen();
      searchTextBox.type(keyword);
    }

    public void lookup_terms() {

      //searchButton.withTimeoutOf(10,TimeUnit.SECONDS).waitUntilClickable().click();
      searchButton.sendKeys(Keys.ENTER);
    }

    public String checkTitle(){
      return getDriver().getTitle();
    }

    public String getSearchResultCount(){
      return searchResultCount.getText();
    }

}
