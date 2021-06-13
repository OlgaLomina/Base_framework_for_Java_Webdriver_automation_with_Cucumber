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
    Integer quizId;

    @BeforeTest
    public void specifyToken () throws FileNotFoundException {
        HashMap<String, String> credentials =  new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");
        token = new AuthorizationService().login(credentials);
    }

    @Test(description = "update quiz")
    public void validateUpdateQuiz () throws FileNotFoundException {

        CreateQuizzesService createQuizzes = new CreateQuizzesService();
        Response responseCreate = createQuizzes.createQuizzes(token);

        // verify and extract data
        Map<String, Object> resultCreate = responseCreate.then()
                .extract()
                .jsonPath()
                .getMap("");
        quizId = (Integer) resultCreate.get("id");

        UpdateQuizzesService updateQuizzes = new UpdateQuizzesService();
        Response responseUpdate = updateQuizzes.updateQuiz(token, quizId);
        // verify and extract data
        Map<String, Object> resultUpdate = responseCreate.then()
                .extract()
                .jsonPath()
                .getMap("");
        quizId = (Integer) resultUpdate.get("id");

        Assert.assertEquals(responseUpdate.statusCode(), 200);
    }
}
