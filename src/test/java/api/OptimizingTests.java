package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class OptimizingTests {


    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void requestSpec() {
        requestSpec = new RequestSpecBuilder().setBaseUri("http://zippopotam.us/").build();
    }

    @BeforeClass
    public static void reponseSpec() {
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }

    @Test
    public void testReturnCode() {

        given().spec(requestSpec).
                when().get("tr/34953").
                then().assertThat().statusCode(200);
    }


    @Test
    public void testResponseBody() {

        given().spec(requestSpec).
                when().get("tr/34953").
                then().spec(responseSpec).
                and().assertThat().
                body("country", equalTo("Turkey"));
    }

    @Test
    public void testExtractData() {
        String response = given().spec(requestSpec).
                when().get("tr/34953").
                then().extract().path("places[0].'place name'");

        Assert.assertEquals(response, "Aydinli Mah.");
    }
}
