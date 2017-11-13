package rest_assured.exercises._01_get;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Exe07_HamcrestAssertions {
    public static void main(String[] args) {
        //RestAssured.proxy("localhost",8888);


        given()
                .when()
                .get("http://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200)
                .body("title", hasItems("maxime id vitae nihil numquam"));

//        Object titles = given()
//                .when()
//                .get("http://jsonplaceholder.typicode.com/posts")
//                .path("title");
//        System.out.println(((ArrayList)titles).size());

    }
}
