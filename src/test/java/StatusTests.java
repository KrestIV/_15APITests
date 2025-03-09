import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class StatusTests {

    @Test
    void notFoundStatusTest() {
        given()
                .log().uri()
                .get("https://selenoid.autotests.cloud/stat")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }
}
