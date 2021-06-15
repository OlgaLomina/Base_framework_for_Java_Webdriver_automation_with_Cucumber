package straightWithoutBdd.api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import straightWithoutBdd.api.services.pojo.UserResponse;
import utils.Loggable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.lessThan;

public class AuthService implements Loggable {

    private String baseUrl = "http://ask-stage.portnov.com";
    private String path = "/api/v1/sign-in";
    private static String loginToken;
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public String login(Map<String, String> user) throws FileNotFoundException {
        Response response = getAuthResponse(user);

        // verify and extract data
        Map<String, Object> result = response.then()
                .extract()
                .jsonPath()
                .getMap("");

        loginToken = "Bearer " + result.get("token");
        getLogger().info(loginToken);


        // POJO EXAMPLE
        var userResponse = response.getBody().as(UserResponse.class);
        getLogger().info("POJO " + userResponse.getUser());

        // Validate Schema
        var responseBody = response.getBody().asString();
        getLogger().info("BODY  " + responseBody);
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/services/schema/Auth.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

        getLogger().info("RESPONSE BODY " + responseBody);

        return loginToken;
    }

    public Response getAuthResponse(Map<String, String> user){
        getLogger().info("Logging in user " + user.get("email"));
        // prepare

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath(path)
                .header(CONTENT_TYPE, JSON)
                .body(user);

        // execute
        return request.when().post();
    }
}
