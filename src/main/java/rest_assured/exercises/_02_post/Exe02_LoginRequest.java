package rest_assured.exercises._02_post;

import io.restassured.http.Headers;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static rest_assured.exercises._02_post.Exe02_LoginRequestParameters.*;

public class Exe02_LoginRequest {
    public static void main(String[] args) {

        validLoginTest();

        secretKeyMissingTest();

        invalidLoginCredentialsTest();

    }

    private static void validLoginTest() {


        Headers headers = given()
                .param(USER_NAME_PARAMETER_NANE, USER_NAME_PARAMETER_VALUE)
                .param(PASSWORD_PARAMETER_NAME, PASSWORD_PARAMETER_VALUE)
                .header(SECRET_KEY_HEADER_NANE, SECRET_KEY_HEADER_VALUE)
                .post(URL)
        .then()
                .statusCode(VALID_LOGIN_STATUS_CODE)
                .body(equalTo(VALID_LOGIN_BODY_TEXT))
                .extract().headers();

        assertThat(headers.getValue(SESSION_ID_HEADER_NAME)).isNotNull();
    }
    private static void secretKeyMissingTest() {
       given()
               .param(USER_NAME_PARAMETER_NANE, USER_NAME_PARAMETER_VALUE)
               .param(PASSWORD_PARAMETER_NAME, PASSWORD_PARAMETER_VALUE)
                .post(URL)
       .then()
                .statusCode(MISSING_SECRET_KEY_STATUS_CODE)
                .body(equalTo(SECRET_KEY_MISSING_BODY_TEXT));
    }

    private static void invalidLoginCredentialsTest() {
        given()
                .param(USER_NAME_PARAMETER_NANE, INVALID_USER_NAME_PARAMETER_VALUE)
                .param(PASSWORD_PARAMETER_NAME, INVALID_PASSWORD_PARAMETER_VALUE)
                .header(SECRET_KEY_HEADER_NANE, SECRET_KEY_HEADER_VALUE)
                .post(URL)
                .then()
                .statusCode(INVALID_CREDENTIALS_STATUS_CODE)
                .body(equalTo(INVALID_CREDENTIALS_BODY_TEXT));
    }
}
