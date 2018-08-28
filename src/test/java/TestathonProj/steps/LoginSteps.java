package TestathonProj.steps;

import TestathonProj.pages.LoginPage;
import TestathonProj.api.LoginApi;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;
    LoginApi loginapi;

    @Step
    public void checkCredentials()
    {
        loginapi.checkCredentials("abc","123");
    }

    @Step
    public void login(String username,String password)
    {
        loginPage.login(username,password);
    }

    @Step
    public void checkLogin()
    {
        System.out.println("check if user is successfully logged in");
    }
}
