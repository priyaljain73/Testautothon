package movies.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginApi {

    private String username;
    private String password;
    private final int SUCCESS_STATUS_CODE=200;

    public void checkCredentials(String usrname,String Password)
    {
        //hit the movies.api in this method
        this.username=username;
        this.password=password;

        Response response=RestAssured.get("http://gmail.com");
        if(SUCCESS_STATUS_CODE==response.getStatusCode())
            assert true;
    }

}
