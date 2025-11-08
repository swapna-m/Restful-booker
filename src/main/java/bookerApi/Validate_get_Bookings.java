        package bookerApi;

import core.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class Validate_get_Bookings {
    @Test(groups = "RegressionSuite")
    public void verifyGetBookings(){
        Response resp = given()
                .when().get("https://restful-booker.herokuapp.com/booking");
        //resp.then().body().;
        System.out.println(resp.asString());
        assertEquals(200, StatusCode.SUCCESS.code);
       List<Integer> bookingIdList = resp.jsonPath().getList("bookingid");
       for(Integer id : bookingIdList) {
           if(id==1160){
               System.out.println("bookingid"+" : "+id);
           }
       }
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
