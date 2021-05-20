package straightWithoutBdd.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RadioButtonCheckboxesPage extends BasePage {

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> radioButtons;

    public RadioButtonCheckboxesPage(WebDriver driver) {
        super(driver);
        url = "http://demo.guru99.com/test/radio.html";
    }

    public void selectAllCheckboxes() {
        waitForVisible(checkBoxes.get(0));
        for (WebElement e : checkBoxes) {
            e.click();
        }
    }

    public String[] getCheckboxesValues() {
        String[] stringArray = new String[checkBoxes.size()];
        for (int i = 0; i < checkBoxes.size(); i++) {
            stringArray[i] = checkBoxes.get(i).getAttribute("value");
        }
        return stringArray;
    }

    public void selectRadioButtonByName(String optionName) {
        waitForVisible(radioButtons.get(0));

        // Using for, same we can do using streams
        for (int i=0; i<radioButtons.size(); i++){
            if (radioButtons.get(i).getAttribute("value").contains(optionName)){
                click(radioButtons.get(i));
                break;
            }
        }
    }

    public boolean isRadioButtonSelectedByName(String name) {
        // streams - more advanced approach
        return radioButtons.stream().filter(e->e.getAttribute("value")
                .contains(name)).findFirst().get().isSelected();
    }

    public String[] getRadioButtonsValues() {
        String[] stringArray = new String[checkBoxes.size()];
        for (int i = 0; i < radioButtons.size(); i++) {
            stringArray[i] = radioButtons.get(i).getAttribute("value");
        }
        return stringArray;
    }

}