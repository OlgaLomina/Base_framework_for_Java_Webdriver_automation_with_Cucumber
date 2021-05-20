package straightWithoutBdd.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadPage extends BasePage{

    @FindBy(css = "#file-upload")
    private WebElement chooseFile;

    @FindBy(css = "#file-submit")
    private WebElement submit;

    @FindBy(css = "#uploaded-files")
    private WebElement uploadedFiles;

    @FindBy(css = "#content > div > h3")
    private WebElement fileUploadedMessage;

    public UploadPage(WebDriver driver) {
        super(driver);
        url = "http://the-internet.herokuapp.com/upload";
    }

    public void uploadFile(String pathToFile){
        waitForVisible(chooseFile);
        chooseFile.sendKeys(pathToFile);
        click(submit);
    }

    public String getUploadedFileText(){
        waitUntilContainsSpecificText(fileUploadedMessage, "File Uploaded!");
        return uploadedFiles.getText();
    }
}