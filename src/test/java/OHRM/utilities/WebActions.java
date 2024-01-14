package OHRM.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebActions {

    private final WebDriver driver;

    public WebActions(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }
}
