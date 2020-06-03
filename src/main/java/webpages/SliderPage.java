package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SliderPage {

    private WebDriver driver;
    private By slider = By.tagName("input");
    private By sliderRange = By.tagName("span");
    private double currentRange;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSlider() {
        driver.findElement(slider).click();
    }

    public boolean currentState(int range) {
        return currentRange == range;
    }

    public void slideIt(double range) {
        String strRange = driver.findElement(sliderRange).getText();
        currentRange = Double.parseDouble(strRange);
        System.out.println("current state is " + currentRange);
        while (currentRange != range) {
            if (currentRange < range) {
                driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
                currentRange = currentRange + 0.5;
            } else if (currentRange > range) {
                driver.findElement(slider).sendKeys(Keys.ARROW_LEFT);
                currentRange = currentRange - 0.5;
            } else break;
        }
    }
}
