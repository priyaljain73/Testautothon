package movies.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author kumar on 28/08/18
 * @project X-search
 */
public class TestApi {

  public String prepareRequest(){

    RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

    RequestSpecification httpRequest = RestAssured.given();

    Response response = httpRequest.request(Method.GET, "/Hyderabad");

    return response.getBody().asString();

  }

}
