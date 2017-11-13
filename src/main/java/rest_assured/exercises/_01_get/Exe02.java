package rest_assured.exercises._01_get;

import static io.restassured.RestAssured.when;

public class Exe02 {
    public static void main(String[] args) {
        String uuid = when()
                            .get("http://httpbin.org/uuid")
                        .then()
                            .statusCode(200)
                            .extract().path("uuid");
        System.out.print("The UUID is: " + uuid);


    }
}
