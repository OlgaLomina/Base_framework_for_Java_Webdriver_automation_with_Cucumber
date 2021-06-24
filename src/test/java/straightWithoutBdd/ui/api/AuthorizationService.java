package straightWithoutBdd.ui.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import utils.Loggable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static utils.RestClient.CONTENT_TYPE;
import static utils.RestClient.JSON;

public class AuthorizationService implements Loggable {

    private String baseUri = "http://ask-stage.portnov.com";
    private String authBasePath = "/api/v1/sign-in";
    Map<String, String> credentials = new HashMap<>();

    public String getToken(Map<String, String> loginCreds) throws IOException {
        String token="";


        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(authBasePath)
                .header(CONTENT_TYPE, JSON)
                .body(loginCreds);

        Response response =request.when()
                .log().all()
                .post();


        Map<String, Object> map= response.then().extract().jsonPath().getMap("");
        token = map.get("token").toString();
        token = "Bearer "+map.get("token").toString();

        getLogger().info("Respomse: "+response.statusCode());
        getLogger().info("Respomse: "+response.getBody().asString());
        getLogger().info("Token: "+token);

        var responseBody= response.getBody().asString();
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/ui/api/Auth.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

        return token;

    }



    public Response getAuthResponse(String email, String password){
        credentials.put("email",email);
        credentials.put("password",password);

        Response response = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(authBasePath)
                .header(CONTENT_TYPE,JSON)
                .body(credentials)
                .when()
                .post();

        getLogger().info("Response code: "+response.statusCode());
        getLogger().info("Response code: "+response.getBody());

        var userResponse = response.getBody().asString();
        Assert.assertEquals(response.statusCode(),200);

        return response;

    }


}
