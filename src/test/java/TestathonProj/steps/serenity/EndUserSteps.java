package TestathonProj.steps.serenity;

import TestathonProj.pages.DictionaryPage;
import TestathonProj.pages.GoogleSearchPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    DictionaryPage dictionaryPage;

    GoogleSearchPage googleSearchPage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void is_at_google_home_page() {
        googleSearchPage.open();
    }

    @Step
    public void enterSearchTermInGoogle(String searchTerm){
        googleSearchPage.searchName(searchTerm);
    }

    @Step
    public void startGoogleSearch(){
        googleSearchPage.openWikiPage();
    }

    @Step
    public void checkTitle(){
        assertThat(googleSearchPage.checkTitle(),equalTo("samsung - Google Search"));
    }

    @Step
    public String getNumberofResults(){
        return googleSearchPage.getSearchResultCount();
    }
}