package fileupload;

import base.BaseTests;
import org.testng.annotations.Test;
import testrelated.Var;
import webpages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    public static final String successUploadHeader = "File Uploaded!";
    public static final String uploadedFileName = "keremFileUpload.txt";

    @Test
    public void testFileUpload(){
        FileUploadPage fileUploadPage = homePage.clickFileUploadPage();
        fileUploadPage.uploadFile(Var.absoluteFilePath);
        assertEquals(fileUploadPage.getSuccessHeader(),successUploadHeader,"file is not uploaded successfully");
        assertEquals(fileUploadPage.getUploadedFileName(),uploadedFileName,"wrong file uploaded");
    }
}
