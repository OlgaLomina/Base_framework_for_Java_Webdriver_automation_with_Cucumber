package straightWithoutBdd.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthorizationService;
import straightWithoutBdd.api.services.CreateQuizzesService;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class CreateQuiz {

    @Test(description = "create quiz")
    public void validateCreateQuiz () throws FileNotFoundException {
        HashMap<String, String> credentials =  new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        String token = new AuthorizationService().login(credentials);
        CreateQuizzesService createQuizzes = new CreateQuizzesService();
        Response response = createQuizzes.createQuizzes(token);

        Assert.assertEquals(response.statusCode(), 200);
    }
}
