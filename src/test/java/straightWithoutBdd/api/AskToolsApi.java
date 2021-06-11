package straightWithoutBdd.api;

import bdd.support.Loggable;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static bdd.support.RestClient.CONTENT_TYPE;
import static bdd.support.RestClient.JSON;
import static org.hamcrest.Matchers.lessThan;

public class AskToolsApi implements Loggable {

    // http://ask-stage.portnov.com/api/v1/sign-in
    String baseUri = "http://ask-stage.portnov.com";
    String basePath = "/api/v1/sign-in";

    @Test(description = "")
    public void login() throws FileNotFoundException {
        //Test data
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        //Auth Service
        RequestSpecification request = RestAssured.given()
                .baseUri(baseUri)
                .basePath(basePath)
                .header(CONTENT_TYPE, JSON)
                .body(credentials);

        Response response = request.post();
        getLogger().info("Response " + response.statusCode());
        getLogger().info("Response " + response.getBody().asString());

        Assert.assertEquals(response.statusCode(), 200);

        // Schema validation
        var userResponse = response.getBody().asString();
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/services/schema/Auth.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(userResponse));

        getLogger().info("USER RESPONSE " + userResponse);


//        // validate time
//        response.then().time( lessThan(100L));
//        // validate time
//        response.then().log().all()
//                .time(lessThan(1000L));

    }
}
