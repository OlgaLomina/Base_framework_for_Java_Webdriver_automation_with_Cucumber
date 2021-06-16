package straightWithoutBdd.api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import straightWithoutBdd.api.services.pojo.NewQuizResponse;
import utils.Loggable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import static utils.TestContext.getData;

public class NewQuiz implements Loggable {
    private String baseUrl = "http://ask-stage.portnov.com";
    private String path = "/api/v1/quiz";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";
    private Integer QuizId;

    public Response newQuiz(String token) throws FileNotFoundException {
        getLogger().info("Creating a new Quiz with token " + token);

        Response response = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath(path)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, token)
                .body(getData("new_quiz"))
                .when()
                .post();

        Map<String, Object> result = response.then()
                .extract()
                .jsonPath()
                .getMap("");

        QuizId = (Integer) result.get("id");
        getLogger().info(QuizId);

        // POJO EXAMPLE
        var userResponse = response.getBody().as(NewQuizResponse.class);
        getLogger().info("POJO " + userResponse.getId());

        // Validate Schema
        var responseBody = response.getBody().asString();
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/services/schema/NewQuizResponse.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

        getLogger().info("RESPONSE BODY " + responseBody);

        return response;
    }
}
