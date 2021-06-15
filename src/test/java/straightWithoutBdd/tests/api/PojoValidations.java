package straightWithoutBdd.tests.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.api.services.AuthService;
import straightWithoutBdd.api.services.pojo.UserResponse;
import utils.Loggable;

import java.io.FileNotFoundException;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;

public class PojoValidations implements Loggable {

    @Test(description = "Validate Authorization")
    public void validateAuthSchema() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher1@gmail.com");
        credentials.put("password", "12345Abc");
        Response response = new AuthService().getAuthResponse(credentials);

        // Status code check
        Assert.assertEquals(response.statusCode(), 200);

        // POJO
        var userResponse = response.getBody().as(UserResponse.class);

        // POJO Based verifications
        Assert.assertEquals(userResponse.getUser().getName(), "Anna Ivanova");
        Assert.assertEquals(userResponse.getUser().getRole(), "TEACHER");
        Assert.assertEquals(userResponse.getUser().getEmail(), "teacher1@gmail.com");
    }



}
