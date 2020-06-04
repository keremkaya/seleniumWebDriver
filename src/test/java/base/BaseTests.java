package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testrelated.BrowserFactory;
import testrelated.Var;
import utils.WindowManager;
import webpages.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    public WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.out.println("browser setting up");
        driver = BrowserFactory.getBrowser("chrome");
        driver.manage().deleteAllCookies();
        driver.get(Var.mainUrl);
        driver.manage().timeouts().pageLoadTimeout(Var.pageLoadTimeout, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("browser killed");
        driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
