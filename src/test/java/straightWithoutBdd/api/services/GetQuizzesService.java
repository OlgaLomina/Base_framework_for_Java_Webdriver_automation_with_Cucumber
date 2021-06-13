package straightWithoutBdd.api.services;

import bdd.support.Loggable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import static org.hamcrest.Matchers.lessThan;

public class GetQuizzesService implements Loggable {

    String baseUri = "http://ask-stage.portnov.com";
    String basePath = "/api/v1/quizzes";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public Response getQuizzes(String token) {
            getLogger().info("Loggin in with token " + token);

            //Auth Service
            RequestSpecification request = RestAssured.given()
                    .log().all()
                    .baseUri(baseUri)
                    .basePath(basePath)
                    .header(CONTENT_TYPE, JSON)
                    .header(AUTH, token);

            // execute
            Response response = request.when()
                    .get();

            //verify and extract data
            response.then()
                    .log().all()
                    .statusCode(200);
            return response;
        }

}
