package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import util.Var;
import webpages.AlertsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        AlertsPage alertsPage = homePage.clickAlertsPage();
        alertsPage.triggerAlert();
        alertsPage.acceptAlert();
        assertEquals(alertsPage.readAlertMsg(), Var.correctMsgJSAlert, "Alert msg fails");
    }

    @Test
    public void testDismissAlert() {
        AlertsPage alertsPage = homePage.clickAlertsPage();
        alertsPage.triggerConfirmAlert();
        assertEquals(alertsPage.alertGetText(), Var.confirmMsgAlert, "wrong text msg");
        alertsPage.clickAlertDismiss();
        assertEquals(alertsPage.readAlertMsg(), Var.afterDismissAlert, "result is wrong");
    }

    @Test
    public void testInputText() {
        AlertsPage alertsPage = homePage.clickAlertsPage();
        alertsPage.triggerPromptButton();
        alertsPage.setInputPrompt(Var.inputTextForPrompt);
        alertsPage.acceptAlert();
        assertEquals(alertsPage.readAlertMsg(), "You entered: " + Var.inputTextForPrompt, "wrong alert msg for prompt");
    }
}
