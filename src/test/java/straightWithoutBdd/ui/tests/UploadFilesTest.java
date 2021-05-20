package straightWithoutBdd.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.UploadPage;

public class UploadFilesTest extends BaseTest {

    @Test
    public void uploadFiles(){
        UploadPage uploadPage = new UploadPage(driver);
        uploadPage.open();
        uploadPage.uploadFile("C:\\Users\\vital\\IdeaProjects\\webdriver-cucumber10\\src\\test\\resources\\data\\automation.yml");
        Assert.assertEquals(uploadPage.getUploadedFileText(), "automation.yml");
    }
}
