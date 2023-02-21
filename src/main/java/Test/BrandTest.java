package Test;

import PageObjects.Brand;

import General.MainCall;

import org.testng.annotations.Test;

public class BrandTest extends Brand {
    Brand brand_obj=new Brand();
    @Test
    public void brandSection(){
        brand_obj.openWeb();
        MainCall.lgnPgObject.clickHomeLogin();
        MainCall.lgnPgObject.ID("auto_store");
        MainCall.lgnPgObject.Password("store123");
        MainCall.lgnPgObject.ValidLogin();
        brand_obj.openHome();
        brand_obj.scrollDown();
        brand_obj.openDove();
        brand_obj.addtoCart();
        brand_obj.openCart();
        //getExtentTest("Add from brand section");


    }

}
