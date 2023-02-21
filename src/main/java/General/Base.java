package General;

import Reports.Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Base {

      static WebDriver driver;
      public static Actions action;
      public ExtentTest extentTest;
      public ExtentReports extentReports;


    @BeforeTest
    public void setup()
    {
          WebDriverManager.chromedriver().driverVersion("110").setup();
          ChromeOptions options = new ChromeOptions();
          driver=new ChromeDriver();
         action= new Actions(driver);

         Reports.startReports();
//         report.getReports();

    }

    @BeforeMethod
    public void beforeMethod(Method method){
        extentTest = Reports.getReports().createTest(method.getName(),"");
    }

    public static  WebDriver getDriver(){

        return driver;
    }
    public static  Actions actbuilder(){

        return action;
    }


//    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
//        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        // after execution, you could see a folder "FailedTestsScreenshots"
//        // under src folder
//        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
//                + ".png";
//        File finalDestination = new File(destination);
//        FileUtils.copyFile(source, finalDestination);
//        return destination;
//    }



    @AfterMethod
    public void status(ITestResult result) throws IOException{



        if(result.getStatus() == ITestResult.FAILURE){
//            extentTest.log(Status.FAIL, "Test Case failed is: " + result.getName());
//            extentTest.log(Status.FAIL, "Test Case failed is: " + result.getThrowable());
            extentTest.fail(result.getMethod().getMethodName() + " test is failed");

            //String screenshotPath = Base.getScreenshot(getDriver(), result.getName());
           // extentTest.log(Status.FAIL, extentTest.addScreenCapture(screenshotPath));


        }

        else if(result.getStatus()== ITestResult.SKIP){
           // extentTest.log(Status.SKIP, "Test Case skipped is: " + result.getName());
            extentTest.skip(result.getMethod().getMethodName() + " test is skipped");
        }
        else if(result.getStatus()== ITestResult.SUCCESS){
          //  extentTest.log(Status.PASS, "Test Case passed is: " + result.getName());
            extentTest.pass(result.getMethod().getMethodName() + " test is passed");
        }





    }





    @AfterSuite
    public void teardown(){

        driver.close();
        driver.quit();
        Reports.getReports().flush();

    }
}
