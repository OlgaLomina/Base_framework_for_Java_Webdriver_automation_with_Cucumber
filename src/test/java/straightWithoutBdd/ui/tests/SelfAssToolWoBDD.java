package straightWithoutBdd.ui.tests;

import org.testng.annotations.Test;
import straightWithoutBdd.ui.pages.SelfAssToolWoBDDPage;

public class SelfAssToolWoBDD extends BaseTest{
    SelfAssToolWoBDDPage sAssTool;

    @Test
    public void navigateToSelfAssTool(){
       sAssTool= new SelfAssToolWoBDDPage();
    }

    @Test
    public void loginWithCredentials(){
        String userId="teacher2@gmail.com";
        String password="12345Abc";
        sAssTool.login(userId,password);

    }
}
