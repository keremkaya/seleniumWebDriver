package hover;

import base.BaseTests;
import org.testng.annotations.Test;
import webpages.HoverPage;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1() {
        HoverPage hoversPage = homePage.clickHoverPage();
        HoverPage.FigureCaption caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "caption is not displayed");
        assertEquals(caption.getTitle(), "name: user1", "title is not displayed");
        assertEquals(caption.getLinkText(), "View profile", "link text is wrong");
        assertTrue(caption.getLink().endsWith("/users/1"), "link is wrong");
    }
}
