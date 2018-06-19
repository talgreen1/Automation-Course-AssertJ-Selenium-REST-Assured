package rest_assured;

import io.restassured.RestAssured;

public class Defaults {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://myhost.org";
        RestAssured.port = 80;
        RestAssured.basePath = "/resource";
        //RestAssured.authentication = basic("username", "password");
        RestAssured.rootPath = "x.y.z";


    }
}
