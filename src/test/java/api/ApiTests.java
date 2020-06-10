package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTests{


    @Test
    public void testFirstAPITest() {

        given().
                when().
                get("http://api.zippopotam.us/TR/34953").
                then().assertThat().
                body("country", equalTo("Turkey"));
    }

    @Test
    public void testCheckStatusCode(){

                given().
                when().get("http://api.zippopotam.us/TR/34953").
                then().assertThat().statusCode(200);

    }

    @Test
    public void testCheckContentType(){

            given().
                    when().get("http://api.zippopotam.us/TR/34953").
                    then().assertThat().contentType(ContentType.JSON);
    }

}
