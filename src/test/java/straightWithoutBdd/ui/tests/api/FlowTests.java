package straightWithoutBdd.ui.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.api.AssignmentsService;
import straightWithoutBdd.ui.api.AuthorizationService;
import straightWithoutBdd.ui.api.NameService;
import straightWithoutBdd.ui.api.QuizService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utils.RestClient.*;
import static utils.TestContext.getData;

public class FlowTests {



    @Test(description = "Getting all the quizzes")
    public void validateQuizzes() throws IOException {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email","teacher2@gmail.com");
        credentials.put("password","12345Abc");

        String token = new AuthorizationService().getToken(credentials);

        Response response = new QuizService().getQuizzes(token);

        //Assertions
        Assert.assertEquals(response.statusCode(),200);


    }

    @Test(description = "Creating a new Quiz")
    public void validateCreateQUiz() throws IOException{
        //Getting the Quiz payload
        Map<String, String> quizMp = getData("new_quiz");

        //Getting the token
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email","teacher2@gmail.com");
        credentials.put("password","12345Abc");
        String token = new AuthorizationService().getToken(credentials);

        //Getting the response
        Response response = new QuizService().createQuiz(quizMp, token);

        //Assertions
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Update quiz")
    public void validateUpdateQuiz() throws IOException{
        //Getting the Quiz payload
        Map<String,String> updtQz= getData("update_quiz");

        //Getting the token
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email","teacher2@gmail.com");
        credentials.put("password","12345Abc");
        String token = new AuthorizationService().getToken(credentials);

        //Getting the response
        Response response = new QuizService().updateQuiz(updtQz,token);

        //Assertions
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test(description = "Updating the name")
    public void validateChangeName() throws IOException{
        //Getting the change name payload
        Map<String, String> newNm= new HashMap<>();
        newNm.put("newName", "Dena Brown");

        //Getting the token
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email","teacher2@gmail.com");
        credentials.put("password","12345Abc");
        String token = new AuthorizationService().getToken(credentials);

        //Getting the response
        Response response = new NameService().changeName(newNm,token);

        //Assertions
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "Validate assignments")
    public void getAssignments() throws IOException {
        //Getting the token
        Map<String, String> credentials = new HashMap<>();
        credentials.put("email","teacher2@gmail.com");
        credentials.put("password","12345Abc");
        String token = new AuthorizationService().getToken(credentials);

        //Getting the response
        Response response = new AssignmentsService().getAssignments(token);

        //Assertions
        Assert.assertEquals(response.statusCode(),200);
    }
}
