package rest_assured.exercises._01_get;

import io.restassured.http.Headers;

import static io.restassured.RestAssured.when;

public class Exe03 {
    public static void main(String[] args) {
        Headers headers = when()
                .get("http://www.google.com")
                .then()
                .statusCode(200)
                .extract().headers();

        System.out.println("Headers count: " + headers.size());
        System.out.println("The headers are:\n" + headers);


    }
}
