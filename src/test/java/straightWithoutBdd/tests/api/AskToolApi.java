package straightWithoutBdd.tests.api;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Loggable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import static utils.RestClient.CONTENT_TYPE;
import static utils.RestClient.JSON;

public class AskToolApi implements Loggable {
    // http://ask-stage.portnov.com/api/v1/sign-in

    @Test(description = "")
    public void login() throws FileNotFoundException {
        // Test data
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");


        // Auth Service
        RequestSpecification request = RestAssured.given()
                .baseUri("http://ask-stage.portnov.com")
                .basePath("/api/v1/sign-in")
                .header(CONTENT_TYPE, JSON)
                .body(credentials);

        Response response = request.post();
        getLogger().info("Response " + response.statusCode());
        getLogger().info("Response " + response.getBody().asString());
        String responseBody = response.getBody().asString();


        Assert.assertEquals(response.statusCode(), 200);

        // Schema validation
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/Auth.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));
    }


}
