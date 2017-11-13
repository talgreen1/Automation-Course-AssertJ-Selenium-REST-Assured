package rest_assured.exercises._01_get;

import io.restassured.path.json.JsonPath;


import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;

public class Exe09_AssertJAssertions {
    public static void main(String[] args) {

        JsonPath jsonPath = given()
                .when()
                .get("http://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200)
                .extract().jsonPath();

        assertThat(jsonPath.getList(".")).size().isEqualTo(100);


    }
}
