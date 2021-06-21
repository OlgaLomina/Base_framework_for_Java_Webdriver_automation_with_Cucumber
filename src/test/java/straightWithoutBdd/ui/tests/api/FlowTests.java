package straightWithoutBdd.ui.tests.api;

import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.api.AssignmentsService;
import straightWithoutBdd.ui.api.AuthorizationService;
import straightWithoutBdd.ui.api.NameService;
import straightWithoutBdd.ui.api.QuizService;
import straightWithoutBdd.ui.api.pojo.UserResponse;
import utils.Loggable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static utils.TestContext.getData;

public class FlowTests implements Loggable {
    AuthorizationService authS = new AuthorizationService();




    @Test(description = "Schema validation")
    public void validateSchema() throws FileNotFoundException {
        Response response = authS.getAuthResponse("teacher5@gmail.com","12345Abc");
        getLogger().info(response.getBody().asString());
        var responseBody = response.getBody().asString();
        InputStream inputStream = new FileInputStream("/Users/idajohn/IdeaProjects/test-framework/test-framework/test-framework/src/test/java/straightWithoutBdd/ui/api/schemas/AuthSchema.json");
        JSONObject rawSchema =new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

    }

    @Test(description = "Pojo validation")
    public  void validatePojo() throws IOException{

        Response response = new AuthorizationService().getAuthResponse("teacher2@gmail.com","12345Abc");
        var userResponse=response.getBody().as(UserResponse.class);
        getLogger().info("POJO "+userResponse.getUser().getRole());

    }

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
