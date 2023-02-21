package PageObjects;

import General.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class Brand extends Base {

//    By homeButton= By.className("active menu_home");
    By DoveButton= By.xpath("//*[@alt='Dove']");
    By newItem= By.xpath("//*[@class='thumbnails grid row list-inline']/div[1]/div[2]/div[3]/a");
   // By cart=By.xpath("//*[@class='block_7']/ul/li/a");
    String actualAmount;
    String actualQuantity;

    public  void openWeb(){
        getDriver().get("https://automationteststore.com/");

    }
    public void openHome(){
        getDriver().findElement(By.xpath("//*[@class='active menu_home']")).click();
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,2500)");

    }

    public void openDove(){
        getDriver().findElement(DoveButton).click();
    }

    public void addtoCart(){
        getDriver().findElement(newItem).click();
         actualAmount= getDriver().findElement(By.xpath("//*[@class='thumbnails grid row list-inline']/div[1]/descendant::div[8]")).getText();
actualQuantity=getDriver().findElement(By.xpath("//div[@class='block_7']/descendant::span[1]")).getText();
        //System.out.println(actualQuantity);

    }

    public void openCart(){
        getDriver().findElement(By.xpath("//*[@class='quick_basket']")).click();

        String expectedAmount= getDriver().findElement(By.xpath("//td[@class='align_right'][1]")).getText();
        String expectedQuantity=getDriver().findElement(By.xpath("//div[@class='input-group input-group-sm']/input")).getAttribute("value");
        //System.out.println(expectedQuantity);

        Assert.assertEquals(actualAmount,expectedAmount,"Amount");
        Assert.assertEquals(actualQuantity,expectedQuantity,"Quantity");

    }
}
