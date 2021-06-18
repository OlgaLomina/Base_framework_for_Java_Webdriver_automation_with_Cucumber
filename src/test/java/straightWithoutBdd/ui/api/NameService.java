package straightWithoutBdd.ui.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Loggable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utils.RestClient.*;

public class NameService implements Loggable {
    private final String baseUri = "http://ask-stage.portnov.com";
    private String changeNameBasePath = "/api/v1/settings/change-name";

    public Response changeName(Map<String, String> newNm, String token) throws IOException {

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(changeNameBasePath)
                .header(AUTH,token)
                .header(CONTENT_TYPE, JSON)
                .body(newNm);

        Response response = request.when()
                .log().all()
                .post();

        getLogger().info("Response code for change name: "+response.statusCode());
        getLogger().info("Response body for change name: "+response.getBody().asString());

        return response;

    }
}
