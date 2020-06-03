package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import webpages.DropdownPage;

import java.util.List;

import static org.testng.Assert.*;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        DropdownPage dropdownPage = homePage.clickDropdownPage();
        String myOption = "Option 1";
        dropdownPage.selectFromDropdown(myOption);
        List<String> selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),1,"incorrect number of selections");
        assertTrue(selectedOptions.contains(myOption),"expected is not selected");
    }
}
