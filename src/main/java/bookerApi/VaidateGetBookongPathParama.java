package bookerApi;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VaidateGetBookongPathParama {
    @Test
    public void validatePathParam(){
        Response resp = given()
                .pathParam("id",1)
                .when()
                .get("https://restful-booker.herokuapp.com/booking/");

    }
}
