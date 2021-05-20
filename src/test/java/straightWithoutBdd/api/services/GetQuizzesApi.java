package straightWithoutBdd.api.services;

import bdd.support.Loggable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetQuizzesApi implements Loggable {

    private String baseUrl = "http://ask-stage.portnov.com";
    private String path = "/api/v1/quizzes";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public Response getQuizzes(String token) {
        getLogger().info("Logging in with token " + token);
        // prepare
        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath(path)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, token);

        // execute
        Response response = request.when()
                .get();

        // verify and extract data
        response.then()
                .log().all()
                .statusCode(200);
        return response;
    }
}
