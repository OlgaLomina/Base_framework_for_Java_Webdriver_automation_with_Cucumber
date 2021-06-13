package straightWithoutBdd.api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.Loggable;

public class GetAssignments implements Loggable {
    private String baseUrl = "http://ask-stage.portnov.com";
    private String path = "/api/v1/assignments";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public Response getAssignments(String token) {
        Response response = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath(path)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, token)
                .when()
                .get();

        // verify and extract data
        response.then()
                .log().all()
                .statusCode(200);
        return response;
    }
}
