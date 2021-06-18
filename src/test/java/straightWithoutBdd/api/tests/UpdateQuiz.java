package straightWithoutBdd.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthorizationService;
import straightWithoutBdd.api.services.CreateQuizzesService;
import straightWithoutBdd.api.services.GetCredentials;
import straightWithoutBdd.api.services.UpdateQuizzesService;
import straightWithoutBdd.api.services.pojo.CreateQuizResponse;

import java.io.FileNotFoundException;


public class UpdateQuiz {

    String token;
    String quizId;

    @BeforeTest
    public void specifyToken() throws FileNotFoundException {
        token = new AuthorizationService().login(GetCredentials.getCredentials());
    }

    @Test(description = "update quiz")
    public void validateUpdateQuiz() throws FileNotFoundException {

        CreateQuizzesService createQuizzes = new CreateQuizzesService();
        Response responseCreate = createQuizzes.createQuizzes(token);
        quizId = responseCreate.getBody().as(CreateQuizResponse.class).getId().toString();

        UpdateQuizzesService updateQuizzes = new UpdateQuizzesService();
        Response responseUpdate = updateQuizzes.updateQuiz(token, quizId);

        Assert.assertEquals(responseUpdate.statusCode(), 200);
    }
}
