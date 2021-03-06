package straightWithoutBdd.api.services;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Loggable;

public class GetQuizzesApi implements Loggable {

    private String baseUrl = "http://ask-stage.portnov.com";
    private String path = "/api/v1/quizzes";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public Response getQuizzes(String token) {
        getLogger().info("Logging in with token " + token);
        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath(path)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, token);

        Response response = request.when()
                .get();

        response.then()
                .log().all()
                .statusCode(200);
        return response;
    }
}
