package OHRM.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testGetTitle() {
        // Navigate to a website
        driver.get("https://www.google.com");

        // Get and print the page title
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // You can add assertions here to validate the title if needed
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
