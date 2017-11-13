package rest_assured.exercises._01_get;

import io.restassured.path.json.JsonPath;
import org.assertj.core.util.Strings;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class Exe11_AssertJAssertions {
    public static void main(String[] args) {

        JsonPath jsonPath = given()
                .when()
                .get("http://jsonplaceholder.typicode.com/photos")
                .then()
                .statusCode(200)
                .extract().jsonPath();
        List<String> thumbnailUrlList = jsonPath.getList("thumbnailUrl ", String.class);
        assertThat(thumbnailUrlList).anySatisfy(a -> assertThat(a).endsWith("55"));


    }
}
