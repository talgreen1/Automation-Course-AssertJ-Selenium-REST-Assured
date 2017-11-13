package rest_assured;

import java.io.File;

import static io.restassured.RestAssured.*;

public class Post {
    public static void main(String[] args) {
//        postWithParameters();
//        postWithBodyJsonText();
//        postWithBodyFile();
        postWithBodyPlainText();
    }

    private static void postWithBodyPlainText() {
        given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body("name=Klepter")
        .when()
                .post("http://putsreq.com/yBukLI50CN0bg1vHIwDj")
        .then()
                .extract().response().prettyPrint();
    }

    private static void postWithBodyFile() {
        given()
                .header("Content-Type", "application/json")
                .body(new File("src/main/resources/postBody.json"))
        .when()
                .post("http://putsreq.com/yBukLI50CN0bg1vHIwDj")
        .then()
                .extract().response().prettyPrint();
    }

    private static void postWithBodyJsonText() {
        given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"Yoni\"}")
        .when()
                .post("http://putsreq.com/yBukLI50CN0bg1vHIwDj")
        .then()
                .extract().response().prettyPrint();
    }

    private static void postWithParameters() {
        given().
                param("name", "Alon")
        .when()
                .post("http://putsreq.com/yBukLI50CN0bg1vHIwDj")
        .then()
                .extract().response().prettyPrint();
    }
}
