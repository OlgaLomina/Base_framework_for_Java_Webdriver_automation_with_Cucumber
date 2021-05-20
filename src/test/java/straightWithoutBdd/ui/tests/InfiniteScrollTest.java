package straightWithoutBdd.ui.tests;

import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.InfiniteScrollPage;

public class InfiniteScrollTest extends BaseTest {

    @Test
    public void scrolling() {
        InfiniteScrollPage scrollingPage = new InfiniteScrollPage(driver);
        scrollingPage.open();
        scrollingPage.scrollToElement();
    }
}
