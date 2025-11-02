package bookerApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostAPIforAuth {
    @Test
    public void validateAuth(){
        String token = getToken();
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization",token)
                .when()
                .get("https://restful-booker.herokuapp.com/booking");
        int StatusCode = response.statusCode();
        assertEquals(StatusCode,200);
        System.out.println("validateAuth executed successfully");
    }
    private String getToken(){
        Response response = given()
                .header("Content-Type","application/json")
                .body("{\"username\":\"admin\",\"password\":\"password123\"}")
                .when()
                .post("https://restful-booker.herokuapp.com/auth");
        int StatusCode = response.statusCode();
        assertEquals(StatusCode,200);
        System.out.println("getToken executed successfully");
        String authToken = response.path("token");
        System.out.println(authToken);
        return authToken;
    }
}
