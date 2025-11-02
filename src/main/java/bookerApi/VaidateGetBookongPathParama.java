package bookerApi;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.testng.Assert.assertEquals;

public class VaidateGetBookongPathParama {
    @Test(description = "valdate id 1")
    public void validatePathParam(){
        Response resp = given()
                .pathParam("id",1)
                .when()
                .get("https://restful-booker.herokuapp.com/booking/{id}");
        String respBody = resp.body().asString();
        if(respBody == null|| respBody.isEmpty()){
            System.out.println("response body is empty");
        }
        else{
            System.out.println("responseBody is not empty"+respBody);
        }
        Headers header = resp.getHeaders();
        for (Header h: header){
            if(h.getName().contains("Server")){
                assertEquals(h.getValue(),"Heroku");
            }

        }


    }
}
