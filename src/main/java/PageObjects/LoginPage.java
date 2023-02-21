package PageObjects;

import General.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends Base {


    By loginHome= By.id("customer_menu_top");
    By id= By.id("loginFrm_loginname");
    By password= By.id("loginFrm_password");
    By loginBtn= By.xpath("//button[@title= 'Login']");



    public  void openWeb(){
    getDriver().get("https://automationteststore.com/");

    }

    public void clickHomeLogin(){
        getDriver().findElement(loginHome).click();

    }

    public void ID(String username ){
        getDriver().findElement(id).sendKeys(username);

    }

    public void Password(String passcode ){
        getDriver().findElement(password).sendKeys(passcode);

    }

    public void ValidLogin(){
        getDriver().findElement(loginBtn).click();
        String loginURL= getDriver().getCurrentUrl();
        Assert.assertEquals(loginURL, "https://automationteststore.com/index.php?rt=account/account", "Valid Login Case");
    }





    public void InvalidLogin(){
        getDriver().findElement(loginBtn).click();
        //String loginURL= getDriver().getCurrentUrl();
//        WebElement errorMsg = getDriver().findElement(By.xpath("//button[@class='close']/following-sibling::text()"));
//        String errorMsg1= errorMsg.getText();
//        String actualError= errorMsg.getText();
//        System.out.println(errorMsg);
        //System.out.println(actualError);
//
//        String expectedError= " Error: Incorrect login or password provided.";
//        Assert.assertEquals(errorMsg1,expectedError, "Invalid Login Case");

        String loginURL= getDriver().getCurrentUrl();
        Assert.assertNotEquals(loginURL, "https://automationteststore.com/index.php?rt=account/account", "inValid Login Case");

    }









}
