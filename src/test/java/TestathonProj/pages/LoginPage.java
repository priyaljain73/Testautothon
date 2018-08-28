package TestathonProj.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http//gmail.com")
public class LoginPage extends PageObject {

   @FindBy(name="login")
    private WebElementFacade login;

    @FindBy(name="Username")
    private WebElementFacade username;

    @FindBy(name="Password")
    private WebElementFacade password;


    public void login(String uname,String pwd) {
        username.type(uname);
        password.type(pwd);
        login.click();
    }
}
