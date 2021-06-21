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
    //http://ask-stage.portnov.com/api/v1/sign-in

//    private String baseUri="http://ask-stage.portnov.com/api/v1/sign-in";

    private String baseUri = "http://ask-stage.portnov.com";
    private String authBasePath = "/api/v1/sign-in";
    Map<String, String> credentials = new HashMap<>();

    public String getToken(Map<String, String> loginCreds) throws IOException {
        String token="";


        //Auth service

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(authBasePath)
                .header(CONTENT_TYPE, JSON)
                .body(loginCreds);

        Response response =request.when()
                .log().all()
                .post();

        //validate time
//        response.then().time(lessThan(2000L));

        Map<String, Object> map= response.then().extract().jsonPath().getMap("");
        token = map.get("token").toString();
        token = "Bearer "+map.get("token").toString();


        //printing out the response to see what information it have
        getLogger().info("Respomse: "+response.statusCode());
        getLogger().info("Respomse: "+response.getBody().asString());
        getLogger().info("Token: "+token);

        //validate schema - option 2
        var responseBody= response.getBody().asString();
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/ui/api/Auth.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

//        return "Bearer "+token;
        return token;

    }

//    public String getToken(String email, String password){
//        Response response = getAuthResponse("email",password);
//        return "Bearer "+response.then().statusCode(200).extract().jsonPath().get("token");
//    }

    public Response getAuthResponse(String email, String password){
        credentials.put("email","teacher2@gmail.com");
        credentials.put("password","12345Abc");

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
