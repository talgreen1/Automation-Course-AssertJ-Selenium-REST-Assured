package rest_assured;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static org.assertj.core.api.Assertions.*;



public class Get {

    public static void main(String[] args) {


//        ArrayList titles = when()
//                .get("http://jsonplaceholder.typicode.com/posts")
//                .path("userId");
//
//        System.out.println(titles);


//        validStatusCodeValidation();
//        invalidStatusCodeValidation();
//        validBodyValidation();

        extractBody();
//        printTheResponse();
//        extractBodyJsonPath();
//        extractBodyJsonPathArray();
        //assertionJsonPath();
//        extractCoockies();
//        extractHeaders();
//        usingParameters();

//        usingTheResponse();
//        printTheStatusLine();
//        getTheResponse();
//        addHeaders();
//        assertionContainsSting();
//        assertionJsonPath();
            //useJsonPathAndAssertJ();
        //useJsonPathAndAssertJ2();
//        validatingHeaders();
//        debugPeek();
        debugFilters();
//        debugProxy();
    }

    private static void debugProxy() {

        RestAssured.proxy("localhost",8888);

        when()
                .get("http://httpbin.org/get").peek()
                .then()
                .statusCode(200);
    }

    private static void debugFilters() {

        // Logging only the request
        RestAssured.filters (new RequestLoggingFilter());

        // Logging only the response
        RestAssured.filters (new ResponseLoggingFilter());

        // Logging both request & response
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());


        when()
                .get("http://httpbin.org/get")
                .then()
                .statusCode(200);
    }

    private static void debugPeek() {
        when()
                .get("http://httpbin.org/get").peek()
        .then()
                .statusCode(200);
    }

    private static void validatingHeaders() {
        // Validate header using Hamcrest Matcher
        when()
                .get("http://httpbin.org/get").peek()
        .then()
                .statusCode(200)
                .header("Content-Type", containsString("json"))
                .header("Content-Length", Integer::parseInt, lessThan(600));


        // Validate header using AssertJ
        Headers headers = when()
                .get("http://httpbin.org/get").peek()
                .then()
                .statusCode(200)
                .extract().headers();

        assertThat(headers.getValue("Content-Type")).contains("json");
        int contentLen = Integer.parseInt(headers.getValue("Content-Length"));
        assertThat(contentLen).isLessThan(600);



    }

    private static void useJsonPathAndAssertJ2() {
        JsonPath jsonPath = when()
                .get("http://jsonplaceholder.typicode.com/posts/1/comments")
                .then()
                .statusCode(200)
                .extract().jsonPath();

        List<Object> ids = jsonPath.getList("id");

        assertThat(ids).containsExactlyInAnyOrder(1,2,3,4,5);
    }

    private static void useJsonPathAndAssertJ() {
        JsonPath jsonPath = when()
                .get("http://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .extract().jsonPath();

        List<Object> cities = jsonPath.getList("address.city");

        assertThat(cities).contains("Howemouth").size().isGreaterThanOrEqualTo(3);
    }

    private static void assertionJsonPath() {
        when()
                .get("http://jsonplaceholder.typicode.com/users")
        .then()
                .statusCode(200)
                .body("id", hasItems(5,700));

    }

    private static void assertionContainsSting() {
        when()
                .get("http://httpbin.org/get")
        .then()
                .statusCode(200)
                .body(containsString("Connection"));

    }

    private static void addHeaders() {
        given()
                .header("Accept-Charset", "utf-8")
                .header("Accept-Language", "en-US")
        .when()
                .get("http://httpbin.org/get")
        .then()
                .statusCode(200)
                .extract().response().prettyPrint();
    }

    private static void getTheResponse() {
        Response response = when()
                .get("http://httpbin.org/get");

        System.out.println(response.body().asString());


    }

    private static void printTheStatusLine() {
        String statusLine = when()
                .get("http://httpbin.org/ip")
                .then()
                .extract().response().getStatusLine();

        System.out.println(statusLine);
    }

    private static void printTheResponse() {
        when()
                .get("http://httpbin.org/ip")
        .then()
                .extract().response().prettyPrint();
    }

    private static void extractCoockies() {
        Map<String, String> cookies = when()
                .get("http://httpbin.org/ip")
                .then()
                .extract().cookies();

        System.out.print(cookies);
    }

    private static void extractHeaders() {
        Headers headers = when()
                .get("http://httpbin.org/ip")
                .then()
                .statusCode(200).extract().headers();

        System.out.print(headers);
    }

    private static void extractBodyJsonPathArray(){
        ArrayList titles = when()
                .get("http://jsonplaceholder.typicode.com/posts")
                .path("title");


        System.out.println(titles.size());

        titles = when()
                .get("http://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200).extract().path("title");


        System.out.println(titles.size());


    }

    private static void extractBodyJsonPath() {
        String origin = when()
                .get("http://httpbin.org/ip")
                .then()
                .statusCode(200).extract().path("origin");
        System.out.print(origin);
    }

    private static void extractBody() {
        String response = when()
                .get("http://httpbin.org/get")
                .then()
                .statusCode(200).extract().asString();
        System.out.print(response);
    }

    private static void usingParameters() {
        given()
                .param("name", "gidi")
                .param("id", 4)
         .when()
                .get("http://httpbin.org/get")
         .then()
                .statusCode(200)
                .extract().response().prettyPrint();
    }

    private static void usingTheResponse() {
        Response res = when()
                .get("http://httpbin.org/");

        System.out.println("\nThe status code is: " + res.statusCode());
        System.out.println("\nThe headers are: " + res.getHeaders());
        System.out.println("\nThe body is: " + res.body().asString());
    }

    private static void validBodyValidation() {
//        when()
//                .get("http://httpbin.org/")
//        .then()
//                .body();
    }

    private static void invalidStatusCodeValidation() {
        try {
            when()
                .get("http://httpstat.us/300")
            .then()
                .statusCode(200);
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }

    private static void validStatusCodeValidation() {
        when()
            .get("http://httpbin.org/get")
        .then()
            .statusCode(200);
    }
}
