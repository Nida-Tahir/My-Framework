package General;
import PageObjects.Brand;
import PageObjects.LoginPage;
import PageObjects.Skincare;
import PageObjects.Apparel;




public class MainCall extends Base{
    Brand brObj=new Brand();
    public static LoginPage lgnPgObject= new LoginPage();
    Skincare skincareObject= new Skincare();

    public static void navigate(){
        getDriver().navigate().back();
    }

    public static void navigateToUrl(String url){
         getDriver().navigate().to(url);
    }


}
