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
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.pojo.CreateQuizResponse;
import straightWithoutBdd.api.services.pojo.UserResponse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.lessThan;
import static bdd.support.RestClient.CONTENT_TYPE;
import static bdd.support.RestClient.JSON;

public class AuthorizationService implements Loggable {
    // http://ask-stage.portnov.com/api/v1/sign-in
    String baseUri = GetContent.getBaseUri();
    String basePath = "/api/v1/sign-in";
    private static String loginToken;

    @Test(description = "login and get token")
    public String login(Map<String, String> user) throws FileNotFoundException {
        getLogger().info("Loggin in user " + user.get("email"));

        //Auth Service
        RequestSpecification request = RestAssured.given()
                .baseUri(baseUri)
                .basePath(basePath)
                .header(CONTENT_TYPE, JSON)
                .body(user);

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

        loginToken = "Bearer " + result.get("token");
        getLogger().info(loginToken);
        String userName = result.get("user").toString();
        getLogger().info(userName);

        // POJO EXAMPLE
        var userResponse = response.getBody().as(UserResponse.class);
        getLogger().info("POJO " + userResponse.getUser().getRole());

        // Validate Schema
        var responseBody = response.getBody().asString();
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/services/schema/Auth.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

        getLogger().info("RESPONSE BODY " + responseBody);

        return loginToken;
    }

}
