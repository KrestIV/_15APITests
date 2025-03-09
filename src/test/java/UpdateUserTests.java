import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UpdateUserTests {


    @Test
    public void successUpdateUserTest(){
        given()
                .log().uri()
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("",hasKey("updatedAt"));
    }
}
