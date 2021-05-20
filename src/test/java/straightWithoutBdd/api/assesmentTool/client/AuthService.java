package straightWithoutBdd.api.assesmentTool.client;

import bdd.support.Loggable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import straightWithoutBdd.api.assesmentTool.client.pojo.UserResponse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class AuthService implements Loggable {

    private String baseUrl = "http://ask-stage.portnov.com";
    private String path = "/api/v1/sign-in";
    private static String loginToken;
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public String login(Map<String, String> user) throws FileNotFoundException {
        getLogger().info("Logging in user " + user.get("email"));
        // prepare
        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath(path)
                .header(CONTENT_TYPE, JSON)
                .body(user);

        // execute
        Response response = request.when()
                .post();

        // verify and extract data
        Map<String, Object> result = response.then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        loginToken = "Bearer " + result.get("token");
        getLogger().info(loginToken);


        // POJO EXAMPLE
        var userResponse = response.getBody().as(UserResponse.class);
        getLogger().info("POJO " + userResponse.getUser());

        // Validate Schema - only structure (add "[] to json in class path" ).
        var responseBody = response.getBody().asString();
        Assert.assertThat(responseBody, matchesJsonSchema(new FileInputStream("src/test/java/straightWithoutBdd/api/assesmentTool/client/schema/Auth.json")));

        // Validate Schema - option 2
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/assesmentTool/client/schema/Auth.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

        return loginToken;
    }
}
