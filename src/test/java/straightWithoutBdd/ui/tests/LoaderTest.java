package straightWithoutBdd.ui.tests;

import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.LoaderPage;

public class LoaderTest extends BaseTest {

    @Test
    public void checkLoader(){
        LoaderPage loaderPage = new LoaderPage(driver);
        loaderPage.open();
        loaderPage.checkProgressBar();
    }
}
