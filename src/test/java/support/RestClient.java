package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import java.util.Map;

import static support.TestContext.getTimestamp;
import static support.TestContext.setTestData;

public class RestClient implements Loggable {

    private String baseUrl = "https://skryabin.com/recruit/api/v1/";
    private static String loginToken;
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";


    public RestClient login(Map<String, String> user) {
        getLogger().info("Logging in user " + user.get("email"));
        // prepare
        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("login")
                .header(CONTENT_TYPE, JSON)
                .body(user);

        // execute
        Response response = request.when()
                .post();

        // verify and extract data
        Map<String, Object> result = response.then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        loginToken = "Bearer " + result.get("token");
        getLogger().info(loginToken);
        return new RestClient();
    }

    public Map<String, Object> createPosition(Map<String, String> position) {
        getLogger().info("Creating position !");
        // prepare
        RequestSpecification request = RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions")
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(position);

        // execute
        Response response = request.when()
                .post();

        // verify and extract
        Map<String, Object> result = response.then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        setTestData("newPosition", result);

        return result;
    }

    public List<Map<String, Object>> getPositions() {
        getLogger().info("Getting all positions");
        return RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");
    }

    public Map<String, Object> updatePosition(Map<String, String> fields, Object id) {
        getLogger().info("Updating position id " + id);

        return RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions/" + id)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(fields)
                .when()
                .patch()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
    }

    public Map<String, Object> getPosition(Object id) {
        getLogger().info("Getting position id " + id);

        return RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions/" + id)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
    }

    public void deletePositionById(Object id) {
        getLogger().info("Deleting position id " + id);

        RestAssured.given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions/" + id)
                .header(AUTH, loginToken)
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(204);
    }

}

