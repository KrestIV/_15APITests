import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class ListUserTests {

    @Test
    public void successListTest(){
        String getParameters = "?page=1";
        given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/users" + getParameters)
                .then()
                .log().status()
                .log().body()
                .body("data.size()", is(6));
    }

    @Test
    public void checkItemStructureTest(){
        String getParameters = "?page=1";
        given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/users" + getParameters)
                .then()
                .log().status()
                .log().body()
                .body("data[0]", hasKey("id"))
                .body("data[0]", hasKey("email"))
                .body("data[0]", hasKey("first_name"))
                .body("data[0]", hasKey("last_name"))
                .body("data[0]", hasKey("avatar"))
        ;
    }
}
