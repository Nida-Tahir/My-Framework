package PageObjects;

import General.Base;
import General.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class Apparel extends Base {

    // By App= By.linkText("Apparel & accessories");
    WebElement App;
    WebElement shoeapp;
    List<WebElement> shirtsList;
    List<WebElement> shoeList;


    WebElement sort;
    WebElement cartt;
    boolean cartIconPresence;
    String expectedQuantity= "2";
    String actualQuantity;


    MainCall main=new MainCall();





    public void openApparel() {
        App = getDriver().findElement(By.xpath("//*[@class='subnav']/ul/li[2]"));
        actbuilder().moveToElement(App).perform();
        getDriver().findElement(By.xpath("//div[@class='subcategories']/ul/li[2]")).click();

    }

    public void sortShirts() {
        getDriver().findElement(By.id("sort")).click();
        getDriver().findElement(By.xpath("//*[@value='p.price-ASC']")).click();
    }

    public void selectshirts() {

        //Store items in list
        for (int i = 0; i < 3; i++) {
            shirtsList = getDriver().findElements(By.xpath("//*[@class='thumbnail']"));


            WebElement element = shirtsList.get(i);
            element.click();
            //Check if item is in stock
            try {
                cartt = getDriver().findElement(By.xpath("//*[@class='cart']"));
                cartIconPresence = cartt.isDisplayed();

            } catch (Exception e) {
                // System.out.println(e);
                System.out.println(cartIconPresence);


            }


            if (cartIconPresence == true) {

                try {
                    getDriver().findElement(By.xpath(" //*[contains(text(),'Size')]/following-sibling::div")).click();

                    getDriver().findElement(By.xpath("//*[text()='Medium  ']")).click();

                    getDriver().findElement(By.xpath("//*[@class='cart']")).click();




                } catch (Exception e) {
                    System.out.println(e);

                }

                MainCall.navigate();

                //getDriver().navigate().back();

            } else {
                //getDriver().navigate().back();
                MainCall.navigate();


            }


        }

    }


    public void openShoes() {
        //getDriver().findElement(By.xpath("//*[text()='Shoes']")).click();
        shoeapp = getDriver().findElement(By.xpath("//*[@class='subnav']/ul/li[2]"));
        actbuilder().moveToElement(shoeapp).perform();
        getDriver().findElement(By.xpath("//div[@class='subcategories']/ul/li[1]")).click();
    }

    public void sortShoes() {
        getDriver().findElement(By.id("sort")).click();
        getDriver().findElement(By.xpath("//*[@value='p.price-DESC']")).click();
    }

    public void selectShoes() {

        for (int i = 0; i < 1; i++) {
            shoeList = getDriver().findElements(By.className("thumbnail"));

            WebElement element1 = shoeList.get(i);
            element1.click();

        }


    }

    public void addShoetoCart(){

        for(int i=0;i< 2;i++){
            WebElement cart= getDriver().findElement(By.className("cart"));
            actbuilder().doubleClick(cart).build().perform();

            actualQuantity= getDriver().findElement(By.xpath( "//div[@class='input-group input-group-sm']/input")).getAttribute("value");

            MainCall.navigate();

        }


       // String expectedQuantity=getDriver().findElement(By.xpath("//div[@class='input-group col-sm-4']/input")).getAttribute("value");
        Assert.assertEquals(actualQuantity,expectedQuantity);


    }
}
