package rest_assured.exercises._01_get;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Exe05_Parameters {
    public static void main(String[] args) {
        //RestAssured.proxy("localhost",8888);


        String body = given()
                .param("q", "java+lesson")
                .when()
                .get("http://www.google.com/search")
                .then()
                .statusCode(200).extract().response().body().asString();

//        System.out.println(body);
        String textToSearch = "id=\"resultStats\">";
        int startIndex = body.indexOf(textToSearch);
        int endIndex = body.indexOf("<", startIndex);

        String numOfResults = body.substring(startIndex + textToSearch.length(), endIndex);
        System.out.println(numOfResults);


    }
}
