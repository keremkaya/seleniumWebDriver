package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import testrelated.Var;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator(){
        homePage.clickDynamicLoadingPage().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultiWinPage().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}
