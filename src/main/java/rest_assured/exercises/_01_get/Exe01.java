package rest_assured.exercises._01_get;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static org.assertj.core.api.Assertions.*;

public class Exe01 {
    public static void main(String[] args) {
        when()
                .get("http://www.google.com").prettyPeek()
         .then()
                .statusCode(200)
                .body(containsString("יותר מזל משכל"));


    }
}
