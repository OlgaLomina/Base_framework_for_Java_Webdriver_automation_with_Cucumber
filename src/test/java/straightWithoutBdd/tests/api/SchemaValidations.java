package straightWithoutBdd.tests.api;

import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthService;
import straightWithoutBdd.api.services.pojo.UserResponse;
import utils.Loggable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;

public class SchemaValidations implements Loggable {

    @Test(description = "Validate Authorization")
    public void validateAuthSchema() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");
        Response response = new AuthService().getAuthResponse(credentials);

        // Status code check
        Assert.assertEquals(response.statusCode(), 200);

        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/Auth.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(response.getBody().asString()));

    }



}
