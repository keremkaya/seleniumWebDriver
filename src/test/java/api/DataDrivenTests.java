package api;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DataDrivenTests {

/*
        @Test(dataProvider = "data-provider")
        public void testMethod(String data) {
            System.out.println("Data is: " + data);
        }
        }
*/

    @DataProvider (name = "data-provider")
    public Object[][] zipCodeAndPlaces(){
        return new Object[][] {
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"tr", "34953", "Aydinli Mah."}
        };
    }

    @Test (dataProvider = "data-provider")
    public void testUsingData (String countryCode, String zipCode, String expectedPlaceName) {

        given().pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
                when().get("http://zippopotam.us/{countryCode}/{zipCode}").
                then().assertThat().body("places[0].'place name'", equalTo(expectedPlaceName));

    }




}
