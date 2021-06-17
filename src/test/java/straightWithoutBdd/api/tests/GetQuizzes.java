package straightWithoutBdd.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthorizationService;
import straightWithoutBdd.api.services.GetCredentials;
import straightWithoutBdd.api.services.GetQuizzesService;

import java.io.FileNotFoundException;


public class GetQuizzes {

    @Test(description = "Validate Quizzes")
    public void validateQuizzes() throws FileNotFoundException {
        String token = new AuthorizationService().login(GetCredentials.getCredentials());
        Response response = new GetQuizzesService().getQuizzes(token);

        Assert.assertEquals(response.statusCode(), 200);
    }
}
