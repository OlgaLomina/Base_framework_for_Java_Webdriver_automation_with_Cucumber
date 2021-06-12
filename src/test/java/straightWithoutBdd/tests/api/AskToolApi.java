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
import straightWithoutBdd.api.services.AuthService;
import straightWithoutBdd.api.services.NewQuiz;
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


        AuthService authService = new AuthService();
        authService.login(credentials);
    }

    @Test(description = "create new quiz")
    public void newQuiz() throws FileNotFoundException {
        // Test data
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");


        NewQuiz nq = new NewQuiz();
        Response response = nq.newQuiz(new AuthService().login(credentials));
        Assert.assertEquals(response.statusCode(), 200);
    }

}
