package straightWithoutBdd.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthorizationService;
import straightWithoutBdd.api.services.ChangeUsersNameService;
import straightWithoutBdd.api.services.GetCredentials;
import straightWithoutBdd.api.services.pojo.ChangeUsersNameResponse;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class ChangeUsersName {

    String token;

    @BeforeTest
    public void specifyToken() throws FileNotFoundException {
        token = new AuthorizationService().login(GetCredentials.getCredentials());
    }

    @Test(description = "Change User's Name")
    public void validateChangeUsersName () throws FileNotFoundException {

        ChangeUsersNameService changeUsersNameService = new ChangeUsersNameService();
        Response responseChange = changeUsersNameService.changeUsersName(token);
        //String message = responseChange.getBody().as(ChangeUsersNameResponse.class).getMessage();

        Assert.assertEquals(responseChange.statusCode(), 200);

    }
}
