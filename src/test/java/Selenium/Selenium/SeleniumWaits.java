package Selenium.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {
    public static void main(String[] args) {
        // Setting up Chrome driver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Creating a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Implicit Wait
        // Set a default wait time for all elements to be present before throwing an exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Explicit Wait
        // Wait for a specific condition to occur before proceeding with the test
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));

        // Fluent Wait
        // Wait for a condition to be true within a specified timeout, checking at regular intervals
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        WebElement fluentElement = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id("elementId")));

        // Example usage:
        // driver.get("https://example.com");
        // WebElement element = driver.findElement(By.id("elementId"));

        // Quitting the WebDriver instance
        driver.quit();
    }
}

