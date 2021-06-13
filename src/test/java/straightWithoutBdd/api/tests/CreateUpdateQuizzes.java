package straightWithoutBdd.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthorizationService;
import straightWithoutBdd.api.services.CreateQuizzesService;
import straightWithoutBdd.api.services.UpdateQuizzesService;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class CreateUpdateQuizzes {

    String token;

    @BeforeTest
    public void specifyToken () throws FileNotFoundException {
        HashMap<String, String> credentials =  new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");
        token = new AuthorizationService().login(credentials);
    }

    @Test(description = "create quiz")
    public void validateCreateQuiz () throws FileNotFoundException {

        CreateQuizzesService createQuizzes = new CreateQuizzesService();
        Response response = createQuizzes.createQuizzes(token);

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(description = "update quiz")
    public void validateUpdateQuiz () throws FileNotFoundException {

    }
}
