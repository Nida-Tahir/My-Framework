package PageObjects;

import General.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Skincare extends Base {

    By skincare= By.xpath("//ul[@class='nav-pills categorymenu']/li[4]");
    By cart=By.className("block_7");
    List<WebElement> skincareList;
    List<WebElement> outOfStock;
    List<WebElement> cartItems;




    public  void openWeb(){
        getDriver().get("https://automationteststore.com/");

    }
    public void openSkincare(){
        getDriver().findElement(skincare).click();
    }

    public void makeList(){


      //  int elementsCount= getDriver().findElements(By.xpath("//span[@class='sale']/following-sibling::div[3]/a")).size();
        skincareList = getDriver().findElements(By.xpath("//span[@class='sale']/following-sibling::div[3]/a"));
        int elementsCount=skincareList.size();

    //  skincareItemsTest= skincareList.stream().map(s->s.getText()).toList();
        for (int i = 0; i < elementsCount; i++) {
            WebElement client = skincareList.get(i);

            client.click();

        }

        getDriver().findElement(cart).click();

         cartItems= getDriver().findElements(By.xpath("//td[@class='align_center']/div"));
        int cartItemsCount=cartItems.size();

        //cartItemsTest=cartItems.stream().map(s->s.getText()).toList();
        Assert.assertEquals(elementsCount,cartItemsCount);

        }



    public void countOutOfStock()

    {
        outOfStock = getDriver().findElements(By.xpath("//div[@class='pricetag jumbotron']/span"));
        int outOfStockSize= outOfStock.size();
       // System.out.println(outOfStockSize);

       // List<String> actualOutOfStock= outOfStock.stream().map(s->s.getText()).toList();
       // System.out.println(actualOutOfStock);
        String expectedOFS="OUT OF STOCK";

        for(int i=0 ;i<outOfStockSize;i++){
            String AOFS= outOfStock.get(i).getText();
        Assert.assertEquals(AOFS,expectedOFS);
        }



    }


    }


