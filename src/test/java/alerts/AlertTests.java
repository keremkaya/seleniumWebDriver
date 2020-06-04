package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import util.Var;
import webpages.AlertsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertTests extends BaseTests {

    public static final String correctMsgJSAlert = "You successfuly clicked an alert";
    public static final String confirmMsgAlert = "I am a JS Confirm";
    public static final String afterDismissAlert = "You clicked: Cancel";
    public static final String inputTextForPrompt = "Hello World!";


    @Test
    public void testAcceptAlert() {
        AlertsPage alertsPage = homePage.clickAlertsPage();
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.readAlertMsg(), correctMsgJSAlert, "Alert msg fails");
    }

    @Test
    public void testDismissAlert() {
        AlertsPage alertsPage = homePage.clickAlertsPage();
        alertsPage.triggerConfirmAlert();
        assertEquals(alertsPage.alertGetText(), confirmMsgAlert, "wrong text msg");
        alertsPage.clickAlertDismiss();
        assertEquals(alertsPage.readAlertMsg(), afterDismissAlert, "result is wrong");
    }

    @Test
    public void testInputText() {
        AlertsPage alertsPage = homePage.clickAlertsPage();
        alertsPage.triggerPromptButton();
        alertsPage.setInputPrompt(inputTextForPrompt);
        alertsPage.acceptAlert();
        assertEquals(alertsPage.readAlertMsg(), "You entered: " + inputTextForPrompt, "wrong alert msg for prompt");
    }
}
