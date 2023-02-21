package Test;

import PageObjects.Skincare;
import org.testng.annotations.Test;

public class SkincareTest extends Skincare {
    Skincare skincare_obj= new Skincare();

    @Test
    public void Filter(){
        skincare_obj.openWeb();
        skincare_obj.openSkincare();
        skincare_obj.makeList();
        //getExtentTest("Filter items");


    }

    @Test
    public void outOfStock(){
        skincare_obj.openWeb();
        skincare_obj.openSkincare();
        skincare_obj.countOutOfStock();
      //  getExtentTest("Out Of Stock Items");


    }
}

