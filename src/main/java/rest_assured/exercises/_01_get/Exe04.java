package rest_assured.exercises._01_get;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import sun.font.TrueTypeFont;

import static io.restassured.RestAssured.when;

public class Exe04 {
    public static void main(String[] args) {
        Response response = when().get("http://httpbin.org/get");

        System.out.println("Content type: " + response.getContentType());
        System.out.println("Response Time: " + response.getTime());

    }
}
