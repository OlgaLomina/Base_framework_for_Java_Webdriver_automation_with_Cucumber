package straightWithoutBdd.ui.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.RadioButtonCheckboxesPage;

public class RadioCheckboxesTest extends BaseTest{


    @Test
    public void testCheckboxes() {
        RadioButtonCheckboxesPage page = new RadioButtonCheckboxesPage(driver);
        page.open();

        // Validate Naming
        String[] expected = {"checkbox1", "checkbox2", "checkbox3"};
        String[] actual = page.getCheckboxesValues();
        Assert.assertArrayEquals(expected, actual);

        // Select All
        page.selectAllCheckboxes();

    }


    @Test
    public void testRadioButtons(){
        RadioButtonCheckboxesPage page = new RadioButtonCheckboxesPage(driver);
        page.open();

        // Validate Selection
        String selectionOption = "Option 3";
        page.selectRadioButtonByName(selectionOption);
        Assert.assertTrue(page.isRadioButtonSelectedByName(selectionOption));

        // Validate Items
        String[] expected = {"Option 1", "Option 2", "Option 3"};
        String[] actual = page.getRadioButtonsValues();
        Assert.assertArrayEquals(expected, actual);
    }
}
