package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By formAuthLink = By.linkText("Form Authentication");
    private By dropdownLink = By.linkText("Dropdown");
    private By hoversLink = By.linkText("Hovers");
    private By keypressesLink = By.linkText("Key Presses");


    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public AuthPage clickFormAuth() {
        driver.findElement(formAuthLink).click();
        return new AuthPage(driver);
    }

    public DropdownPage clickDropdownPage() {
        driver.findElement(dropdownLink).click();
        return new DropdownPage(driver);
    }

    public HoverPage clickHoverPage(){
        driver.findElement(hoversLink).click();
        return new HoverPage(driver);
    }

    public KeyPressesPage clickKeypressesPage(){
        driver.findElement(keypressesLink).click();
        return new KeyPressesPage(driver);
    }

}
