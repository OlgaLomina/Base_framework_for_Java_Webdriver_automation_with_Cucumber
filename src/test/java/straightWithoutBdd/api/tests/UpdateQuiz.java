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

public class UpdateQuiz {

    String token;
    String quizId;

    @BeforeTest
    public void specifyToken() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");
        token = new AuthorizationService().login(credentials);
    }

    @Test(description = "update quiz")
    public void validateUpdateQuiz() throws FileNotFoundException {

        CreateQuizzesService createQuizzes = new CreateQuizzesService();
        Response responseCreate = createQuizzes.createQuizzes(token);
        String responseBody = responseCreate.getBody().asString();
        quizId = responseBody.substring(6, 9);

        UpdateQuizzesService updateQuizzes = new UpdateQuizzesService();
        Response responseUpdate = updateQuizzes.updateQuiz(token, quizId);

        Assert.assertEquals(responseUpdate.statusCode(), 200);
    }
}
