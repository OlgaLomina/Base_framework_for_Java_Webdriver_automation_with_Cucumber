package straightWithoutBdd.api.tests;

import java.io.FileNotFoundException;
import straightWithoutBdd.api.services.GetCredentials;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthorizationService;
import straightWithoutBdd.api.services.GetAssignmentsService;
import straightWithoutBdd.api.services.GetCredentials;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class GetAssignments {

    String token;

    @BeforeTest
    public void specifyToken() throws FileNotFoundException {
        token = new AuthorizationService().login(GetCredentials.getCredentials());
    }

    @Test(description = "Validate Assignments")
    public void validateAssign() {
        Response responseAssign = new GetAssignmentsService().getAssignments(token);

        Assert.assertEquals(responseAssign.statusCode(), 200);
    }

}
