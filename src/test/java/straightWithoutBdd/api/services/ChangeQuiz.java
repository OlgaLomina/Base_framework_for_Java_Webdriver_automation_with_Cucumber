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

public class ChangeQuiz implements Loggable {
    private String baseUrl = "http://ask-stage.portnov.com";
    private String path = "/api/v1/quiz";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public Response changeQuiz(String token, String id) throws FileNotFoundException {
        getLogger().info("Changing a Quiz with token " + token);
        Map<String, String> updatedQuiz = getData("changed_quiz");
        updatedQuiz.put("id", id);
        Response response = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath(path)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, token)
                .body(updatedQuiz)
                .when()
                .post();

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
