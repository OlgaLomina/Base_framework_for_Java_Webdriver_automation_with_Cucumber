package straightWithoutBdd.api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.Loggable;

public class AskChangeName implements Loggable {
    private String baseUrl = "http://ask-stage.portnov.com";
    private String path = "/api/v1/settings/change-name";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public void changeName(String newName, String token) {
        Response response = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath(path)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, token)
                .body("{\"newName\":" + "\"" + newName + "\"}")
                .when()
                .post();
        response.then().statusCode(200);
    }
}
