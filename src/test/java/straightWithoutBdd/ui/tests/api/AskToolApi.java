package straightWithoutBdd.ui.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.api.AuthorizationService;
import straightWithoutBdd.ui.api.pojo.UserResponse;
import utils.Loggable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static utils.RestClient.*;
import static utils.TestContext.getData;

public class AskToolApi implements Loggable {
    //http://ask-stage.portnov.com/api/v1/sign-in

    String baseUri = "http://ask-stage.portnov.com";
    String authBasePath = "/api/v1/sign-in";
    String quizBasePath = "/api/v1/quizzes";
    String createQuizBasePath = "/api/v1/quiz";
    String changeNameBasePath = "/api/v1/settings/change-name";
    String getAssignmentsBasePath = "api/v1/assignments";
    String token;
    AuthorizationService authS = new AuthorizationService();

  @Test
  public void getTokenTest() throws IOException{
      String tk = getToken();
      getLogger().info("Token is: "+tk);
  }
  public String getToken() throws IOException {
        //Test data
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email","teacher2@gmail.com");
        credentials.put("password","12345Abc");

        //Auth service

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(authBasePath)
                .header(CONTENT_TYPE, JSON)
                .body(credentials);

        Response response =request.when()
                .log().all()
                .post();

        //validate time
//        response.then().time(lessThan(2000L));

        Map<String, Object> map= response.then().extract().jsonPath().getMap("");
        token = map.get("token").toString();
        token = "Bearer "+map.get("token").toString();


        //printing out the response to see what information it have
        getLogger().info("Response: "+response.statusCode());
        getLogger().info("Respomse: "+response.getBody().asString());
        getLogger().info("Token: "+token);

        //POJO Example
        var userResponse=response.getBody().as(UserResponse.class);
        getLogger().info("POJO "+userResponse.getUser().getRole());



        //validate schema - option 2
        var responseBody= response.getBody().asString();
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/ui/api/Auth.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

        Assert.assertEquals(response.statusCode(),200);
//        return "Bearer "+token;
        return token;

    }

    @Test
    public void login() throws IOException{
      Map<String, String> credMap = new HashMap<>();
      credMap.put("email","teacher2@gmail.com");
      credMap.put("password","12345Abc");
      authS.getToken(credMap);
    }

    @Test(description = "Schema validation")
    public void validateSchema() throws FileNotFoundException {
        Response response = authS.getAuthResponse("teacher5@gmail.com","12345Abc");
        getLogger().info(response.getBody().asString());
        var responseBody = response.getBody().asString();
        InputStream inputStream = new FileInputStream("//straightWithoutBdd.ui//api/schemas/AuthSchema.json");
        JSONObject rawSchema =new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(responseBody));

    }

    @Test(description = "reading all the quizzes")
    public void getQuizzes() throws IOException {
//        getToken();
        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(quizBasePath)
                .header(CONTENT_TYPE,JSON)
                .header(AUTH,getToken());

        Response response= request.when()
                .log().all()
                .get();

        getLogger().info("Response code for quiz: "+response.statusCode());
        getLogger().info("Response body for quiz: "+response.getBody().asString());
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(description = "creating a quiz")
    public void createQuiz() throws IOException {

        Map<String, String> quizMp = getData("new_quiz");

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(createQuizBasePath)
                .header(AUTH,getToken())
                .header(CONTENT_TYPE,JSON)
                .body(quizMp);

        Response response = request.when()
                .log().all()
                .post();

        getLogger().info("Response code for quiz: "+response.statusCode());
        getLogger().info("Response body for quiz: "+response.getBody().asString());
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void updateQuiz() throws IOException{
        Map<String,String> updtQz= getData("update_quiz");

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(createQuizBasePath)
                .header(AUTH,getToken())
                .header(CONTENT_TYPE,JSON)
                .body(updtQz);

        Response response = request.when()
                .log().all()
                .put();

        getLogger().info("Response code for updating quiz: "+response.statusCode());
        getLogger().info("Response body for updating quiz: "+response.getBody().asString());
        Assert.assertEquals(response.statusCode(),200);


    }

    @Test
    public void changeName() throws IOException {
        Map<String, String> newNm= new HashMap<>();
        newNm.put("newName", "Dena Brown");

        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUri)
                .basePath(changeNameBasePath)
                .header(AUTH,getToken())
                .header(CONTENT_TYPE, JSON)
                .body(newNm);

        Response response = request.when()
                .log().all()
                .post();

        getLogger().info("Response code for change name: "+response.statusCode());
        getLogger().info("Response body for change name: "+response.getBody().asString());
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void getAssignments() throws IOException {

        RequestSpecification request = RestAssured.given()
                .log().all()
                .given()
                .baseUri(baseUri)
                .basePath(getAssignmentsBasePath)
                .header(AUTH,getToken())
                .header(CONTENT_TYPE,JSON);

        Response response = request
                .log().all()
                .when()
                .get();

        getLogger().info("Response code for getting assignments: "+response.statusCode());
        getLogger().info("Response body for getting assignments: "+response.getBody().asString());
        Assert.assertEquals(response.statusCode(),200);
    }
}
