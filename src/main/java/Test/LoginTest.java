package Test;

import PageObjects.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends LoginPage {
    LoginPage login_obj= new LoginPage();

    @Test
    public void ValidLoginTest(){
        login_obj.openWeb();
        login_obj.clickHomeLogin();
        login_obj.ID("auto_store");
        login_obj.Password("store123");
        login_obj.ValidLogin();
        //getExtentTest("login");

    }

    @Test
      public void InvalidLoginTest(){
       login_obj.openWeb();
       login_obj.clickHomeLogin();
       login_obj.ID("Auto_store");
       login_obj.Password("store234");
       login_obj.InvalidLogin();
         //   getExtentTest("Invalid login");

    }



}
