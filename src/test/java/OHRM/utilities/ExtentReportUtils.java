package OHRM.utilities;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExtentReportUtils {

    private ExtentTest extentTest;

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

    private String captureScreenshot() {
        try {
            // Assuming your WebDriver instance is named "driver"
            TakesScreenshot ts = (TakesScreenshot) driver;
            return ts.getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to capture screenshot";
        }
    }
}
