package Selenium.Selenium;

import org.testng.Assert;
import org.testng.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestNGBasics2 {

	private static final Logger log = LoggerFactory.getLogger(TestNGBasics2.class);
	
    // This method will run once before any test method
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite Testng basics 2");
        log.info("this is before suite method");
    }

    // This method will run once before all test methods in a test class
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class Testng basics 2");
    }

    // This method will run before each test method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method Testng basics 2");
    }

    // Test method 1
    @Test(priority = 1)
    public void testMethod1() {
        System.out.println("Test Method 1 Testng basics 2");
        Assert.assertEquals(2 + 2, 4);
    }

    // Test method 2 with dependencies on testMethod1
    @Test(priority = 2, dependsOnMethods = "testMethod1")
    public void testMethod2() {
        System.out.println("Test Method 2 Testng basics 2");
    }

    // This method will run after each test method
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method Testng basics 2");
    }

    // This method will run once after all test methods in a test class
    @AfterClass
    public void afterClass() {
        System.out.println("After Class Testng basics 2");
    }

    // This method will run once after all test methods in all test classes
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite Testng basics 2");
    }
}
