package rest_assured.exercises._01_get;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class Exe08_HamcrestAssertions {
    public static void main(String[] args) {
        //RestAssured.proxy("localhost",8888);


        given()
                .when()
                .get("http://jsonplaceholder.typicode.com/photos")
                .then()
                .statusCode(200)
                .body(".",hasSize(greaterThan(300)))
                .body("thumbnailUrl", hasItems(endsWith("55")));


        ArrayList titles = when()
                .get("http://jsonplaceholder.typicode.com/posts")
                .path("title");
//
//
//        System.out.println(titles.size());

    }
}
