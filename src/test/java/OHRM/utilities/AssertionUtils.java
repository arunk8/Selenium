package OHRM.utilities;

import org.testng.Assert;

public class AssertionUtils {

    private ExtentReportUtils extentReportUtils;

    public AssertionUtils(ExtentReportUtils extentReportUtils) {
        this.extentReportUtils = extentReportUtils;
    }

    // Assert that two values are equal
    public void assertEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
            extentReportUtils.logPass("Assertion Passed: " + message);
        } catch (AssertionError e) {
            extentReportUtils.logFailWithScreenshot("Assertion Failed: " + message);
            throw e;
        }
    }

    // Assert that a condition is true
    public void assertTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
            extentReportUtils.logPass("Assertion Passed: " + message);
        } catch (AssertionError e) {
            extentReportUtils.logFailWithScreenshot("Assertion Failed: " + message);
            throw e;
        }
    }

    // Assert that a condition is false
    public void assertFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition, message);
            extentReportUtils.logPass("Assertion Passed: " + message);
        } catch (AssertionError e) {
            extentReportUtils.logFailWithScreenshot("Assertion Failed: " + message);
            throw e;
        }
    }
}
