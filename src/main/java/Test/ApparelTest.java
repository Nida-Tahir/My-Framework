package Test;

import General.Base;
import PageObjects.Apparel;

import org.testng.annotations.Test;
import General.MainCall;


public class ApparelTest extends Base {
    Apparel apparel_obj= new Apparel();
    @Test(priority = 0)
    public void topThreeShirts(){
        MainCall.lgnPgObject.openWeb();
        apparel_obj.openApparel();
        apparel_obj.sortShirts();
        apparel_obj.selectshirts();
       // getExtentTest("Add Top Three Shirts To Cart");
    }

    @Test(priority = 1)
    public void shoes(){

     //   getExtentTest("Add Shoe To Cart");
        System.out.println("Shoes Test");
        MainCall.lgnPgObject.openWeb();

        apparel_obj.openShoes();
        apparel_obj.sortShoes();
        apparel_obj.selectShoes();
        apparel_obj.addShoetoCart();



    }


}
