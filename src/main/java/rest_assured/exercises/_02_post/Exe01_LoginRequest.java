package rest_assured.exercises._02_post;

import io.restassured.http.Headers;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class Exe01_LoginRequest {
    public static void main(String[] args) {

        validLoginTest();

        secretKeyMissingTest();

        invalidLoginCredentialsTest();

    }

    private static void validLoginTest() {
        String URL = "http://putsreq.com/GYq6JsWcoqXnDHNJHQFj";

        Headers headers = given()
                .param("username", "admin")
                .param("password", "123456")
                .header("SECRET-KEY", "Ken-Sent-Me")
                .post(URL)
        .then()
                .statusCode(200)
                .body(equalTo("Login OK"))
                .extract().headers();

        assertThat(headers.getValue("SESSION-ID")).isNotNull();
    }
    private static void secretKeyMissingTest() {
        String URL = "http://putsreq.com/GYq6JsWcoqXnDHNJHQFj";

       given()
                .param("username", "admin")
                .param("password", "123456")
                .post(URL)
       .then()
                .statusCode(400)
                .body(equalTo("Key is missing"));
    }

    private static void invalidLoginCredentialsTest() {
        String URL = "http://putsreq.com/GYq6JsWcoqXnDHNJHQFj";

        given()
                .param("username", "admin111")
                .param("password", "1234564444")
                .header("SECRET-KEY", "Ken-Sent-Me")
                .post(URL)
                .then()
                .statusCode(401)
                .body(equalTo("Login Failed"));
    }
}
