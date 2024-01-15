package tests;

import models.lombok.LoginBodyLombokModel;
import models.lombok.LoginResponseLombokModel;
import models.pojo.LoginBodyModel;
import models.pojo.LoginResponseModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginExtendedTests {
 /*
    1. Make request (POST) to https://reqres.in/api/login
        with body { "email": "eve.holt@reqres.in", "password": "cityslicka" }
    2. Get response { "token": "QpwL5tke4Pnpja7X4" }
    3. Check "token" is "QpwL5tke4Pnpja7X4" and status code 200
  */

    @Test
    void successfulLoginBadPracticeTest() {
        String authData = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";

        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()

        .when()
            .post("https://reqres.in/api/login")

        .then()
            .log().status()
            .log().body()
            .statusCode(200)
            .body("token", is("QpwL5tke4Pnpja7X4"));
    }


    @Test
    void successfulLoginPojoTest() {
        LoginBodyModel authData = new LoginBodyModel();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseModel response = given()
                .body(authData)
                .contentType(JSON)
                .log().uri()

        .when()
            .post("https://reqres.in/api/login")

        .then()
            .log().status()
            .log().body()
            .statusCode(200)
            .extract().as(LoginResponseModel.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
    }

@Test
    void successfulLoginLombokTest() {
    LoginBodyLombokModel authData = new LoginBodyLombokModel();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseLombokModel response = given()
                .body(authData)
                .contentType(JSON)
                .log().uri()

        .when()
            .post("https://reqres.in/api/login")

        .then()
            .log().status()
            .log().body()
            .statusCode(200)
            .extract().as(LoginResponseLombokModel.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
    }


}
