package straightWithoutBdd.ui.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Loggable;

import java.io.IOException;
import java.util.Map;

import static utils.RestClient.*;
import static utils.TestContext.getData;

public class QuizService implements Loggable {

    private String baseUri = "http://ask-stage.portnov.com";
    private String quizBasePath = "/api/v1/quizzes";
    private String createQuizBasePath = "/api/v1/quiz";


    public Response getQuizzes(String token) throws IOException {

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(quizBasePath)
                .header(CONTENT_TYPE,JSON)
                .header(AUTH,token);

        Response response= request.when()
                .log().all()
                .get();

        getLogger().info("Response code for quiz: "+response.statusCode());
        getLogger().info("Response body for quiz: "+response.getBody().asString());
        return response;

    }

    public Response createQuiz(Map<String, String> quizData, String token) throws IOException {

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(createQuizBasePath)
                .header(AUTH,token)
                .header(CONTENT_TYPE,JSON)
                .body(quizData);

        Response response = request.when()
                .log().all()
                .post();

        getLogger().info("Response code for quiz: "+response.statusCode());
        getLogger().info("Response body for quiz: "+response.getBody().asString());

        return response;
    }

    public Response updateQuiz(Map<String, String> updtQz, String token) throws IOException{

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(createQuizBasePath)
                .header(AUTH,token)
                .header(CONTENT_TYPE,JSON)
                .body(updtQz);

        Response response = request.when()
                .log().all()
                .put();

        getLogger().info("Response code for updating quiz: "+response.statusCode());
        getLogger().info("Response body for updating quiz: "+response.getBody().asString());

        return response;
    }
}
