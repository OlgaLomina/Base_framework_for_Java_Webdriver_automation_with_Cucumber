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

    private Object specifyToken;


    @BeforeTest
    public void specifyToken (){
        HashMap<String, String> credentials =  new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");
    }

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

    @Test(description = "update quiz")
    public void validateUpdateQuiz () throws FileNotFoundException {
        HashMap<String, String> credentials =  new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");
        Integer quizId;

        String token = new AuthorizationService().login(credentials);
        CreateQuizzesService createQuizzes = new CreateQuizzesService();
        Response responseCreate = createQuizzes.createQuizzes(token);

        // verify and extract data
        Map<String, Object> resultCreate = responseCreate.then()
                .extract()
                .jsonPath()
                .getMap("");
        quizId = (Integer) resultCreate.get("id");

        UpdateQuizzesService updateQuizzes = new UpdateQuizzesService();
        Response responseUpdate = updateQuizzes.updateQuiz(quizId);
        // verify and extract data
        Map<String, Object> resultUpdate = responseCreate.then()
                .extract()
                .jsonPath()
                .getMap("");
        quizId = (Integer) resultUpdate.get("id");

        Assert.assertEquals(responseUpdate.statusCode(), 200);
    }
}
