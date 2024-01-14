package OHRM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OHRM.utilities.WebActions;

public class LoginPage {

    private final WebDriver driver;
    private final WebActions webActions;

    // Locators
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.webActions = new WebActions(driver);
    }

    public void navigateToLoginPage() {
        System.out.println("Navigating to the login page: https://opensource-demo.orangehrmlive.com/");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    public void enterUsername(String username) {
        webActions.sendKeys(usernameInput, username);
        System.out.println("Entered username: " + username);
    }

    public void enterPassword(String password) {
        webActions.sendKeys(passwordInput, password);
        System.out.println("Entered password");
    }

    public void clickLoginButton() {
        webActions.click(loginButton);
        System.out.println("Clicked on the Login button");
    }

    public void login(String username, String password) {
        navigateToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        By errorMessageLocator = By.id("spanMessage");
        WebElement errorMessageElement = driver.findElement(errorMessageLocator);
        String errorMessage = errorMessageElement.getText();
        System.out.println("Error message displayed: " + errorMessage);
        return errorMessage;
    }
}
