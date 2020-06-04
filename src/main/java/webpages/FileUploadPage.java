package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;
    private By inputField = By.xpath("//input[@id='file-upload']");
    private By uploadButton = By.xpath("//input[@id='file-submit']");
    private By successUploadHeader = By.tagName("h3");
    private By uploadedFileName = By.id("uploaded-files");


    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }

    public void uploadFile(String absolutePathOfFile){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadedFileName(){
        return driver.findElement(uploadedFileName).getText();
    }

    public String getSuccessHeader(){
        return driver.findElement(successUploadHeader).getText();
    }

}
