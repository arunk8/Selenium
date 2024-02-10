package Selenium.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumWaits {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // **1. Implicit Wait:** (Global, simple but less precise)
        System.out.println("\n**Implicit Wait:**");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com"); // Implicitly waits for up to 10 seconds for any element

        // **2. Explicit Wait (WebDriverWait):** (Conditional, precise, recommended)
        System.out.println("\n**Explicit Wait (WebDriverWait):**");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // - Wait for element presence, visibility, or other conditions
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
        // - Use FluentWait for custom polling (e.g., checking availability every 2 seconds)
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement dynamicElement = fluentWait.until(d -> d.findElement(By.cssSelector(".dynamic-element")));
        
        // **3. Thread.sleep (Not recommended):** (Avoid if possible)
        System.out.println("\n**Thread.sleep (Not recommended):**");
        // **Avoid Thread.sleep due to its inaccuracy and unpredictable nature.**

        driver.quit();
    }
}

