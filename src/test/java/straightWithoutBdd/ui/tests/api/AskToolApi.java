package straightWithoutBdd.ui.tests.api;

import bdd.support.Loggable;

import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.api.*;
import straightWithoutBdd.pojo.NewQuizResponse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;



public class AskToolApi implements Loggable {
    //http://ask-stage.portnov.com/api/v1/sign-in
    String baseUri = "http://ask-stage.portnov.com/";
    String basePath = "/api/v1/sign-in";
    String quizPath = "/api/v1/quizzes";
    String createQuizPath = "/api/v1/quiz";
    String changeNamePath = "/api/v1/users/change-name/:";
    String getAssignmentsPath = "/api/v1/assignments";
    HashMap<String, String> credentials = new HashMap<>();
    String token = "";
    private Integer QuizId;
    AuthorizationService auth = new AuthorizationService();

    @Test
    public void login() {
       auth.getToken("teacher5@gmail.com", "12345Abc");
    }

    @Test
    public void validationSchema() throws FileNotFoundException {
        Response response = auth.getAuthResponse("teacher5@gmail.com", "12345Abc");
        System.out.println(response.getBody().asString());

        var userResponse = response.getBody().asString();
        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/schemas/AuthSchemaResponse.json");
        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
        Schema schema = SchemaLoader.load(rawSchema);
        schema.validate(new JSONObject(userResponse));
    }

    @Test
    public void getQuizzes() throws FileNotFoundException {
    HashMap<String, String> credentials = new HashMap<>();
    credentials.put("email", "teacher5@gmail.com");
    credentials.put("password", "12345Abc");

    new GetQuizzes().getQuizzes(new AuthorizationService().getToken("teacher5@gmail.com", "12345Abc"));
}

    @Test
    public void getAssignments() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        new GetAssignments().getAssignments(new AuthorizationService().getToken("teacher5@gmail.com", "12345Abc"));
    }

    @Test
    public void newQuiz() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

        CreateQuiz nq = new CreateQuiz();
        Response response = nq.newQuiz(new AuthorizationService().getToken("teacher5@gmail.com", "12345Abc"));
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void changeQuiz() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");

       CreateQuiz nq = new CreateQuiz();
        Response response = nq.newQuiz(new AuthorizationService().getToken("teacher5@gmail.com", "12345Abc"));
        String id = response.getBody().as(NewQuizResponse.class).getId().toString();
        getLogger().info("id for change is " + id);

        UpdateQuiz cq = new UpdateQuiz();
        cq.updateQuiz(new AuthorizationService().getToken("teacher5@gmail.com", "12345Abc"), id);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void changeName() throws FileNotFoundException {
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("email", "teacher5@gmail.com");
        credentials.put("password", "12345Abc");
        String token = new AuthorizationService().getToken("teacher5@gmail.com", "12345Abc");
        new ChangeName().changeName("Iryna Valadimirovaaa", token);
    }

}

//        //Test data
//        credentials.put("email", "teacher5@gmail.com");
//        credentials.put("password", "12345Abc");
//
//        // Auth Service
//        RequestSpecification request = (RequestSpecification) RestAssured.given()
//                .baseUri(baseUri)
//                .basePath(basePath)
//                .header(CONTENT_TYPE, JSON)
//                .body(credentials);
//
//        //Execute
//        Response response = request.when().post();
//
//        //validate time
//        response.then().time(lessThan(1000l));
//
//        //validate time
//        response.then().log().all().time(lessThan(1000l));
//
//        //verify and extract data
//        Map<String, Object> result = response.then().extract().jsonPath().getMap("");
//        loginToken = "Bearer" + result.get("token");
//
//        //Logs
//        getLogger().info("Response: " + response.statusCode());
//        getLogger().info("Response: " + response.getBody().asString());
//
//
//        //Schema validation
//        var userResponse = response.getBody().asString();
//        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/Auth.json");
//        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
//        Schema schema = SchemaLoader.load(rawSchema);
//        schema.validate(new JSONObject(userResponse));
//
//        Assert.assertEquals(response.statusCode(), 200);


//    @Test
//    public String getToken() throws FileNotFoundException {
//        credentials.put("email", "teacher5@gmail.com");
//        credentials.put("password", "12345Abc");
//        Response response = (Response) RestAssured.given()
//                .baseUri(baseUri)
//                .basePath(basePath)
//                .header(CONTENT_TYPE, JSON)
//                .body(credentials)
//                .when()
//                .post();
//
//        getLogger().info("Response: " + response.statusCode());
//        getLogger().info("Response: " + response.getBody().asString());
//
//        var responseBody = response.getBody().asString();
//        InputStream inputStream = new FileInputStream("src/test/java/straightWithoutBdd/api/Auth.json");
//        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
//        Schema schema = SchemaLoader.load(rawSchema);
//        schema.validate(new JSONObject(responseBody));
//
//        Assert.assertEquals(response.statusCode(), 200);
//        return "Bearer " + response.then().extract().jsonPath().getMap("").get("token");
//
//    }

//    @Test
//    public void getQuizzes1() {
//        auth.getToken("teacher5@gmail.com", "12345Abc");
//        Response response = RestAssured.given()
//                .baseUri(baseUri)
//                .basePath(quizPath)
//                .header(CONTENT_TYPE, JSON)
//                .header(AUTH, token)
//                .when()
//                .get();
//
//        getLogger().info("Response " + response.statusCode());
//        getLogger().info("Response " + response.getBody().asString());
//
//    }
//
//    @Test
//    public Response createQuiz() throws FileNotFoundException {
//
//        Response response = RestAssured.given()
//                .baseUri(baseUri)
//                .basePath(createQuizPath)
//                .header(CONTENT_TYPE, JSON)
//                .header(AUTH, token)
//                .body(getData("newQuiz"))
//                .when()
//                .post();
//
//        Map<String, Object> result = response.then().extract().jsonPath().getMap("");
//        QuizId = (Integer) result.get("id");
//        getLogger().info(QuizId);
//        getLogger().info("Creating a new Quiz with token " + token);
//
//        // Validate Schema
//        var responseBody = response.getBody().asString();
//        InputStream inputStream = new FileInputStream("/src/test/java/straightWithoutBdd/api/NewQuizResponse.json");
//        JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
//        Schema schema = SchemaLoader.load(rawSchema);
//        schema.validate(new JSONObject(responseBody));
//
//        getLogger().info("RESPONSE BODY " + responseBody);
//
//        return response;
//
//    }
//
//    @Test
//    public void updateQuiz() throws FileNotFoundException {
//
//        Response response = RestAssured.given()
//                .baseUri(baseUri)
//                .basePath(createQuizPath)
//                .header(CONTENT_TYPE, JSON)
//                .header(AUTH, token)
//                .when()
//                .put();
//
//        getLogger().info("Response " + response.statusCode());
//        getLogger().info("Response " + response.getBody().asString());
//    }
//
//    @Test
//    public void changeName(String newName, int userId, String token) {
//        Response response = RestAssured.given()
//                .log().all()
//                .baseUri(baseUri)
//                .basePath(changeNamePath  + userId)
//                .header(CONTENT_TYPE, JSON)
//                .header(AUTH, token)
//                .body("\"name\":" + "\"" + newName + "\"")
//                .when()
//                .post();
//        response.then().statusCode(200);
//    }
//
//    @Test
//    public Response getAssignments(String token) {
//        Response response = RestAssured.given()
//                .log().all()
//                .baseUri(baseUri)
//                .basePath(getAssignmentsPath)
//                .header(CONTENT_TYPE, JSON)
//                .header(AUTH, token)
//                .when()
//                .get();
//
//        // verify and extract data
//        response.then()
//                .log().all()
//                .statusCode(200);
//        return response;
//    }
//









