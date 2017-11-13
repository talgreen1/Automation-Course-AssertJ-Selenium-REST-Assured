package rest_assured.exercises._01_get;

import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class Exe12_HeadersAssertions {
    public static void main(String[] args) {

        Headers headers = given()
                .when()
                .get("http://jsonplaceholder.typicode.com/photos")
                .then()
                .statusCode(200)
                .extract().headers();

        assertThat(headers).size().isEqualTo(13);
        System.out.println("The content length is " + headers.getValue("Content-Length"));

        System.out.println(headers.getValue("Content-Length"));
    }
}
