package bookerApi;

import core.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class Validate_get_Bookings {
    @Test
    public void verifyGetBookings(){
        Response resp = given()
                .when().get("https://restful-booker.herokuapp.com/booking");
        //resp.then().body().;
        System.out.println(resp.asString());
        assertEquals(200, StatusCode.SUCCESS.code);

    }
    @Test
    public void validateIncorrectUrl(){
        Response resp = given()
                .when().get("https://restful-booker.herokuapp.com/bookin");
        //resp.then().body().;
        System.out.println(resp.asString());
        assertEquals(404, StatusCode.NOT_FOUND.code);
    }

}
