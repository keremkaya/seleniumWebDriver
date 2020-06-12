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

    @Test
    public void testLogAll(){

        given().log().all().
                when().get("http://api.zippopotam.us/TR/34953").
                then().log().body();
    }

    @Test
    public void testHasItem(){
        given().
                when().
                get("http://api.zippopotam.us/TR/34953").
                then().assertThat().
                body("places.'place name'", hasItem("Aydinli Mah."));
    }

    @Test
    public void testUsageOfNot(){
        given().
                when().get("http://api.zippopotam.us/TR/34953").
                then().assertThat().body("places.'place name'", not(hasItem("Aydinli Mah. 1")));
    }

    @Test
    public void testExpectOne(){
        given().
                when().get("http://api.zippopotam.us/TR/34953").
                then().assertThat().body("places.'place name'", hasSize(1));
    }


}
