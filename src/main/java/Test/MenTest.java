package Test;
import General.MainCall;
import PageObjects.Men;
import org.testng.annotations.Test;

public class MenTest extends Men {
    Men men=new Men();
    @Test
    public void addtoCart(){
        MainCall.lgnPgObject.openWeb();
        men.openMen();
        men.MakeList();
        men.addToCart();
        men.check();
       // getExtentTest("Add from Men Section");


    }
}
