package straightWithoutBdd.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthService;
import straightWithoutBdd.api.services.GetQuizzesApi;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class FlowsTests {

    @Test(description = "Validate Quizzes")
    public void validateQuizzes() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher1@gmail.com");
        credentials.put("password", "12345Abc");

        String token = new AuthService().login(credentials);
        Response response = new GetQuizzesApi().getQuizzes(token);

        // Assertions
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test(description = "Validate Authorization")
    public void validateAuth() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher1@gmail.com");
        credentials.put("password", "12345Abc");
        new AuthService().login(credentials);
    }
}