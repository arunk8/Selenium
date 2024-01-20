package OHRM.Tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import OHRM.utilities.AssertionUtils;
import OHRM.utilities.ExtentReportUtils;


public class BaseClass {
    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest extentTest;
    public ExtentReportUtils extentReportUtils;
    public AssertionUtils assertionUtils;
    public String userName ="Admin";
    public String password = "admin123";
    public String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();	
        driver.manage().window().maximize();
        extentReportUtils = new ExtentReportUtils(driver);
        assertionUtils =  new AssertionUtils(extentReportUtils);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
//    public void setExtentTest() {
//    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
//        ExtentReports extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//
//        // Create ExtentTest
//        ExtentTest extentTest = extent.createTest("Test Name", "Test Description");
//    }
    
    
    public void captureScreenshot(String testName) {
        try {
            // Convert WebDriver object to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Capture screenshot as File
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Get the current timestamp
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
            String timestamp = dateFormat.format(new Date());

            // Define the destination path and file name with the timestamp
            Path destPath = Paths.get("screenshots", testName + "_" + timestamp + ".png");

            // Copy the screenshot to the destination path
            Files.copy(srcFile.toPath(), destPath);

            System.out.println("Screenshot captured: " + destPath.toString());
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
            
        }
    }
}
