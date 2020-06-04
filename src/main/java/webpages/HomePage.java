package webpages;

import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By formAuthLink = By.linkText("Form Authentication");
    private By dropdownLink = By.linkText("Dropdown");
    private By hoversLink = By.linkText("Hovers");
    private By keypressesLink = By.linkText("Key Presses");
    private By sliderLink = By.linkText("Horizontal Slider");
    private By alertsLink = By.linkText("JavaScript Alerts");
    private By fileUploadLink = By.linkText("File Upload");
    private By dynamicLoadingLink = By.linkText("Dynamic Loading");

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

    public HoverPage clickHoverPage() {
        driver.findElement(hoversLink).click();
        return new HoverPage(driver);
    }

    public KeyPressesPage clickKeypressesPage() {
        driver.findElement(keypressesLink).click();
        return new KeyPressesPage(driver);
    }

    public SliderPage clickSliderPage() {
        driver.findElement(sliderLink).click();
        return new SliderPage(driver);
    }

    public AlertsPage clickAlertsPage() {
        driver.findElement(alertsLink).click();
        return new AlertsPage(driver);
    }

    public FileUploadPage clickFileUploadPage() {
        driver.findElement(fileUploadLink).click();
        return new FileUploadPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoadingPage() {
        driver.findElement(dynamicLoadingLink).click();
        return new DynamicLoadingPage(driver);
    }


}
