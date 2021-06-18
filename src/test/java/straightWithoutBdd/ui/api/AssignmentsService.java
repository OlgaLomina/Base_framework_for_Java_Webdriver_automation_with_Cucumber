package straightWithoutBdd.ui.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utils.Loggable;

import java.io.IOException;

import static utils.RestClient.*;

public class AssignmentsService implements Loggable {
    String baseUri = "http://ask-stage.portnov.com";
    String getAssignmentsBasePath = "api/v1/assignments";

    public Response getAssignments(String token) throws IOException {

        RequestSpecification request = RestAssured.given()
                .log().all()
                .given()
                .baseUri(baseUri)
                .basePath(getAssignmentsBasePath)
                .header(AUTH,token)
                .header(CONTENT_TYPE,JSON);

        Response response = request
                .log().all()
                .when()
                .get();

        getLogger().info("Response code for getting assignments: "+response.statusCode());
        getLogger().info("Response body for getting assignments: "+response.getBody().asString());

        return response;
    }
}
