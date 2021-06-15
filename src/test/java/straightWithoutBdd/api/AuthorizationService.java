package straightWithoutBdd.api;

import bdd.support.Loggable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import static bdd.support.RestClient.CONTENT_TYPE;
import static bdd.support.RestClient.JSON;
import static org.hamcrest.Matchers.lessThan;

public class AuthorizationService implements Loggable {
    String baseUri = "http://ask-stage.portnov.com/";
    String basePath = "/api/v1/sign-in";
    Map<String, String> credentials =  new HashMap<>();

    public String getToken(String email, String password) {
       Response response = getAuthResponse(email, password);
       return "Bearer " + response.then().extract().jsonPath().getMap("").get("token");
    }

    public Response getAuthResponse (String email, String password){
        credentials.put("email", email);
        credentials.put("password", password);

        Response response = (Response) RestAssured.given()
                .baseUri(baseUri)
                .basePath(basePath)
                .header(CONTENT_TYPE, JSON)
                .body(credentials)
                .when()
                .post();

        getLogger().info("Response: " + response.statusCode());
        getLogger().info("Response: " + response.getBody().asString());

        response.then().log().all().time(lessThan(1000L));

        return response;
    }

}
