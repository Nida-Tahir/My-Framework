package Reports;

import General.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reports extends Base {


    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports=new ExtentReports();
    public ExtentTest extentTest;
    public final static String  reportPath =System.getProperty("user.dir") + "\\reports\\Test Report.html";
    public static ExtentSparkReporter startReports(){
        System.out.println("Hello Reports");

        extentSparkReporter= new ExtentSparkReporter(reportPath);
        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setReportName("Results");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports.attachReporter(extentSparkReporter);
        // extentReports.setSystemInfo();


        return extentSparkReporter;

    }



//    public  ExtentTest getExtentTest(String s){
//        extentTest= extentReports.createTest(s);
//        return extentTest;
//
//    }


    public static ExtentReports getReports(){

        if(extentReports != null){
            return extentReports;
        }
        else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }





}


