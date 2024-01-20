package OHRM.utilities;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentReportUtils {

    private ExtentTest extentTest;
    private WebDriver driver; // Assuming WebDriver is your base class and driver is the instance

    // Constructor to initialize the driver
    public ExtentReportUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void setExtentTest(ExtentTest extentTest) {
        this.extentTest = extentTest;
    }

    public void logPass(String stepName) {
        extentTest.log(LogStatus.PASS, stepName);
    }

    public void logFailWithScreenshot(String stepName) {
        extentTest.log(LogStatus.FAIL, stepName + extentTest.addScreenCapture(captureScreenshot()));
    }

    public void logInfo(String stepName) {
        extentTest.log(LogStatus.INFO, stepName);
    }

    public void attachScreenshot() {
        extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(captureScreenshot()));
    }

    // Use the captureScreenshot method from the base class
    private String captureScreenshot() {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            return ts.getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to capture screenshot";
        }
    }
}
