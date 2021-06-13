package straightWithoutBdd.tests.api;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.*;
import straightWithoutBdd.api.services.pojo.NewQuizResponse;
import utils.Loggable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import static utils.RestClient.CONTENT_TYPE;
import static utils.RestClient.JSON;

public class AskToolApi implements Loggable {
    // http://ask-stage.portnov.com/api/v1/sign-in

    @Test(description = "")
    public void login() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        new AuthService().login(credentials);
    }


    @Test(description = "get Quizzes")
    public void getQuizzes() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        new GetQuizzesApi().getQuizzes(new AuthService().login(credentials));
    }

    @Test(description = "get Quizzes")
    public void getAssignments() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        new GetAssignments().getAssignments(new AuthService().login(credentials));
    }

    @Test(description = "create new quiz")
    public void newQuiz() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        NewQuiz nq = new NewQuiz();
        Response response = nq.newQuiz(new AuthService().login(credentials));
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(description = "change quiz")
    public void changeQuiz() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        NewQuiz nq = new NewQuiz();
        Response response = nq.newQuiz(new AuthService().login(credentials));
        String id = response.getBody().as(NewQuizResponse.class).getId().toString();
        getLogger().info("id for change is " + id);

        ChangeQuiz cq = new ChangeQuiz();
        cq.changeQuiz(new AuthService().login(credentials), id);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(description = "change name")
    public void changeName() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "4hocinelosane0@rtfs.site");
        credentials.put("password", "12345");
        String token = new AuthService().login(credentials);
        new AskChangeName().changeName("New Name for Artur", 12463, token);
    }

}
