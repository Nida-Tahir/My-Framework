package PageObjects;

import General.Base;
import General.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Men extends Base {
    MainCall main=new MainCall();

    List<WebElement> elementList;
    List<WebElement> cartItemList;
    public void openMen(){
        //getDriver().findElement(By.xpath("//*[@class='nav-pills categorymenu']/li[6]")).click();
        getDriver().findElement(By.linkText("MEN")).click();
    }

    public void MakeList(){
        elementList= getDriver().findElements(By.className("fixed"));

    }

    public void addToCart(){
        for(int i=0;i< elementList.size(); i++){
            elementList= getDriver().findElements(By.className("fixed"));

            WebElement item = elementList.get(i);
            String eleText=item.getText();

            Boolean Actualname =eleText.endsWith("M");

            if(Actualname ==true)
            {

                item.click();
                getDriver().findElement(By.className("cart")).click();

            }

            MainCall.navigateToUrl("https://automationteststore.com/index.php?rt=product/category&path=58");



         //   getDriver().navigate().to("https://automationteststore.com/index.php?rt=product/category&path=58");


        }
    }

    public void check(){
        getDriver().findElement(By.className("block_7")).click();
        cartItemList= getDriver().findElements(By.xpath("//*[@class='align_left']/a"));

        for(int i=0;i< cartItemList.size(); i++){
           // cartItemList= getDriver().findElements(By.className("fixed"));
            cartItemList= getDriver().findElements(By.xpath("//*[@class='align_left']/a"));


            WebElement cartitem = cartItemList.get(i);
            String itemText=cartitem.getText();
            //System.out.println(itemText);

            Boolean expectedName =itemText.endsWith("m");
            //System.out.println(expectedName);

            Assert.assertTrue(expectedName);
    }

    }
}
