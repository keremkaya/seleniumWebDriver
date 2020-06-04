package wait;

import base.BaseTests;
import org.testng.annotations.Test;
import webpages.DynamicLoadingExample1Page;
import webpages.DynamicLoadingExample2Page;
import webpages.DynamicLoadingPage;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    private static final String loadedText = "Hello World!";

    @Test
    public void testWaitUntilHidden(){
        DynamicLoadingExample1Page dynamicLoadingPage = homePage.clickDynamicLoadingPage().clickExample1();
        dynamicLoadingPage.clickStartButton();
        assertEquals(dynamicLoadingPage.getLoadedText(),loadedText,"text could not be loaded");
    }

    @Test
    public void testWaitUntilVisibility(){
        DynamicLoadingExample2Page dynamicLoadingPage = homePage.clickDynamicLoadingPage().clickExample2();
        dynamicLoadingPage.clickStartButton();
        assertEquals(dynamicLoadingPage.loadedTextAfter(),loadedText,"string is not loaded");
    }
}
