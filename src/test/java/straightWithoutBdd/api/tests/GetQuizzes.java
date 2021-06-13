package straightWithoutBdd.api.tests;

import io.restassured.response.Response;
import org.apache.tools.ant.taskdefs.Get;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthorizationService;
import straightWithoutBdd.api.services.GetQuizzesService;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class GetQuizzes {

    @Test(description = "Validate Quizzes")
    public void validateQuizzes() throws FileNotFoundException {
        HashMap<String, String> credentials =  new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        String token = new AuthorizationService().login(credentials);
        Response response = new GetQuizzesService().getQuizzes(token);

        Assert.assertEquals(response.statusCode(), 200);
    }
}
