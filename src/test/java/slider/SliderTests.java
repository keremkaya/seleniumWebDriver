package slider;

import base.BaseTests;
import org.testng.annotations.Test;
import webpages.SliderPage;

import static org.testng.Assert.assertTrue;

public class SliderTests extends BaseTests {

    @Test
    public void testSlider(){
        SliderPage sliderPage = homePage.clickSliderPage();
        sliderPage.clickOnSlider();
        sliderPage.slideIt(0);
        assertTrue(sliderPage.currentState(0),"slider is not at desired");
    }

}
