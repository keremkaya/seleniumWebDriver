package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import util.BrowserFactory;
import util.Var;
import webpages.HomePage;

public class BaseTests {

    public WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.out.println("browser setting up");
        driver = BrowserFactory.getBrowser("chrome");
        driver.manage().deleteAllCookies();
        driver.get(Var.mainUrl);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("browser killed");
        driver.quit();
    }
}
