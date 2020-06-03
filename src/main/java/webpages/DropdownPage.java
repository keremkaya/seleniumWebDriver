package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromDropdown(String option) {

        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        //get all web elements and convert into string then adds a new list which will be returned
        List<String> collect = selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
        return collect;
    }

    private Select findDropdownElement() {
        //finds the dropdown element(a helping method)
        return new Select(driver.findElement(dropdown));
    }

}
