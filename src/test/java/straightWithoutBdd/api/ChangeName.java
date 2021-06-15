package straightWithoutBdd.api;

import bdd.support.Loggable;
import io.restassured.response.Response;import io.restassured.RestAssured;

    public class ChangeName implements Loggable {
        private String baseUri = "http://ask-stage.portnov.com";
        private String changeNamePath = "/api/v1/settings/change-name";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String JSON = "application/json";
        public static final String AUTH = "Authorization";

        public void changeName(String newName, String token) {
            Response response = RestAssured.given()
                    .log().all()
                    .baseUri(baseUri)
                    .basePath(changeNamePath)
                    .header(CONTENT_TYPE, JSON)
                    .header(AUTH, token)
                    .body("{\"newName\":" + "\"" + newName + "\"}")
                    .when()
                    .post();
            response.then().statusCode(200);
        }


}
