import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTests {

    @Test
    public void successDeleteUserTest(){
        given()
                .log().uri()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().body()
                .log().status()
                .statusCode(204);
    }
}
