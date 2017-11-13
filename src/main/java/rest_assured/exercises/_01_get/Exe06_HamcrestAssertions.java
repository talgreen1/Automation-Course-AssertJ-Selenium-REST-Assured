package rest_assured.exercises._01_get;

import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Exe06_HamcrestAssertions {
    public static void main(String[] args) {
        //RestAssured.proxy("localhost",8888);


        given()
                .when()
                .get("http://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200)
                .body(".", hasSize(100));




    }
}
