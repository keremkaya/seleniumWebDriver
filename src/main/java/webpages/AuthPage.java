package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage {

    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginBtn = By.cssSelector("#login button");


    public AuthPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public SecureAreaPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new SecureAreaPage(driver);
    }




}

