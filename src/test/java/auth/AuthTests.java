package auth;

import base.BaseTests;
import org.testng.annotations.Test;
import testrelated.Var;
import webpages.AuthPage;
import webpages.SecureAreaPage;

import static org.testng.Assert.*;

public class AuthTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        AuthPage authPage = homePage.clickFormAuth();
        authPage.setUsername(Var.correctUsername);
        authPage.setPassword(Var.correctPassword);
        SecureAreaPage secureAreaPage = authPage.clickLoginBtn();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Wrong alert msg!");
    }
}
