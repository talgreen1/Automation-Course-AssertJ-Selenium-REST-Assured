package rest_assured.exercises._01_get;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class Exe10_AssertJAssertions {
    public static void main(String[] args) {

        JsonPath jsonPath = given()
                .when()
                .get("http://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200)
                .extract().jsonPath();

        assertThat(jsonPath.getList("title")).contains("maxime id vitae nihil numquam");


    }
}
