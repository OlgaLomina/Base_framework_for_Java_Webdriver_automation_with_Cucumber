package straightWithoutBdd.api.services;

import bdd.support.Loggable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import straightWithoutBdd.api.services.pojo.CreateQuizResponse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import static bdd.support.TestContext.getData;

public class CreateQuizzesService implements Loggable {
    String basePath = "/api/v1/quiz";
    String baseUri = GetContent.getBaseUri();
    public static final String CONTENT_TYPE = GetContent.getContentType();
    public static final String JSON = GetContent.getJson();
    public static final String AUTH = GetContent.getAuth();

    private Integer quizId;

    public Response createQuizzes(String token) throws FileNotFoundException {
        getLogger().info("Loggin in with token " + token);

        //Auth Service
        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(basePath)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, token)
                .body(getData("newQuiz_example"));

        // execute
        Response response = request.when().post();

        getLogger().info("Response " + response.statusCode());
        getLogger().info("Response " + response.getBody().asString());

        Assert.assertEquals(response.statusCode(), 200);

        // verify and extract data
        Map<String, Object> result = response.then()
                .extract()
                .jsonPath()
                .getMap("");

        quizId = (Integer) result.get("id");
        getLogger().info(quizId);

        // POJO EXAMPLE
        var createQuizResponse = response.getBody().as(CreateQuizResponse.class);
        getLogger().info("POJO " + createQuizResponse.getId());

        // Validate Schema
        var responseBody = response.getBody().asString();
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/services/schema/CreateQuizz.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

        getLogger().info("RESPONSE BODY " + responseBody);

        return response;
    }

}
