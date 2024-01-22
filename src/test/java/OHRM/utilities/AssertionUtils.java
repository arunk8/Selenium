package OHRM.utilities;

import org.testng.Assert;

public class AssertionUtils {

    public AssertionUtils() {
    }

    // Assert that two values are equal
    public void assertEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (Exception | AssertionError  e) {
            throw e;
        }
        
    }

    // Assert that a condition is true
    public void assertTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
        } catch (AssertionError e) {
            throw e;
        }
    }

    // Assert that a condition is false
    public void assertFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition, message);
        } catch (AssertionError e) {
            throw e;
        }
    }
}
