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
import straightWithoutBdd.api.services.pojo.ChangeUsersNameResponse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static bdd.support.TestContext.getData;

public class ChangeUsersNameService implements Loggable {
    //http://ask-stage.portnov.com/api/v1/settings/change-name
    String baseUri = "http://ask-stage.portnov.com";
    String basePath = "/api/v1/settings/change-name";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";
    //"/:userId"

    public Response changeUsersName(String token) throws FileNotFoundException {
        getLogger().info("Login in with token " + token);
        //getLogger().info("UserId : " + userId);

        //Auth Service
        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(basePath)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, token)
                .body(getData("updateUsersName"));

        // execute
        Response response = request.when().post();

        getLogger().info("Response " + response.statusCode());
        getLogger().info("Response " + response.getBody().asString());

        Assert.assertEquals(response.statusCode(), 200);

        String message = response.getBody().as(ChangeUsersNameResponse.class).getMessage();
        getLogger().info(message);


        // Validate Schema
        var responseBody = response.getBody().asString();
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/services/schema/UpdateUsersName.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

        getLogger().info("RESPONSE BODY " + responseBody);

        return response;
    }

}
