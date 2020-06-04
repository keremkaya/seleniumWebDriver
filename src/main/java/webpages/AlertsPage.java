package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By triggerAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By alertResult = By.id("result");
    private By triggerConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath("//button[text()='Click for JS Prompt']");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert() {
        driver.findElement(triggerAlertButton).click();
    }

    public void triggerConfirmAlert() {
        driver.findElement(triggerConfirmButton).click();
    }

    public void triggerPromptButton() {
        driver.findElement(triggerPromptButton).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void clickAlertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public String alertGetText() {
        return driver.switchTo().alert().getText();
    }

    public String readAlertMsg() {
        return driver.findElement(alertResult).getText();
    }

    public void setInputPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


}
