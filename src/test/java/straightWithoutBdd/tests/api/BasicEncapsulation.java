package straightWithoutBdd.tests.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthService;
import straightWithoutBdd.api.services.GetQuizzesApi;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class BasicEncapsulation {

    String token;

    @Test(description = "Validate Quizzes")
    public void validateQuizzes() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher1@gmail.com");
        credentials.put("password", "12345Abc");
        token = new AuthService().login(credentials);
        Response response = new GetQuizzesApi().getQuizzes(token);

        // Assertions
        Assert.assertEquals(response.statusCode(), 200);

        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method 1 " + ". Thread id is: " + id);

    }

    @Test(description = "Validate Authorization")
    public void validateAuth() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method 1 " + ". Thread id is: " + id);
        new AuthService().login(credentials);
    }

    @Test(description = "Validate Quizzes")
    public void validateQuizzes2() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher3@gmail.com");
        credentials.put("password", "12345Abc");
        token = new AuthService().login(credentials);
        Response response = new GetQuizzesApi().getQuizzes(token);

        // Assertions
        Assert.assertEquals(response.statusCode(), 200);

    }
}