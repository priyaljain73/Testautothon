package movies.stepImpl;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DirectorNameStepsImpl {

    public void checkapi(){
        System.out.println("trying the api now");
        Response response= RestAssured.get("https://en.wikipedia.org/w/api.php?action=query&titles=interstellar&prop=revisions&rvprop=content&format=json&formatversion=2");
        response.prettyPrint();
    }
}

