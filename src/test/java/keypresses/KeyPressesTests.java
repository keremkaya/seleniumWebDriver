package keypresses;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import webpages.KeyPressesPage;

import static org.testng.Assert.assertEquals;

public class KeyPressesTests extends BaseTests {

    @Test
    public void testBackspace() {
        KeyPressesPage keyPressesPage = homePage.clickKeypressesPage();
        keyPressesPage.enterText("K" + Keys.BACK_SPACE);
        assertEquals(keyPressesPage.getResult(), "You entered: BACK_SPACE", "could not press back_space");
    }

    @Test
    public void testPi() {
        KeyPressesPage keyPressesPage = homePage.clickKeypressesPage();
        keyPressesPage.enterPi();
    }

}
