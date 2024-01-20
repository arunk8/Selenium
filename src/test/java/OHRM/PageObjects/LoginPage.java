package OHRM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import OHRM.utilities.AssertionUtils;
import OHRM.utilities.ExtentReportUtils;

import OHRM.utilities.WebActions;

public class LoginPage {

    private final WebDriver driver;
    private final WebActions webActions;
    public final AssertionUtils assertion;
    public final ExtentReportUtils extReports;

    // Locators
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.xpath("//*[text()=' Login ']");
    
    //validation xpaths
    By brandLogo = By.xpath("//img[contains(@src,'orangehrm')]");
    By dashboardText = By.xpath("//h6[text()='Dashboard']");

    public LoginPage(WebDriver driver,ExtentReportUtils extentReportUtils, AssertionUtils assertionUtils) {
        this.driver = driver;
        this.webActions = new WebActions(driver);
		this.extReports = extentReportUtils;
        this.assertion = assertionUtils;
    }

    public void navigateToLoginPage() {
        System.out.println("Navigating to the login page: https://opensource-demo.orangehrmlive.com/");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebActions.waitForPageToLoad(driver);
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
        webActions.waitForSeconds(5);
    }

    public String getErrorMessage() {

        By errorMessageLocator = By.id("spanMessage");
        WebElement errorMessageElement = driver.findElement(errorMessageLocator);
        String errorMessage = errorMessageElement.getText();
        System.out.println("Error message displayed: " + errorMessage);
        return errorMessage;
    }
    
    
    public void validateLogin() {
		//1st validation 
    	String actualSrcText = webActions.getAttributeValue(brandLogo,"src");
//    	actualSrcText= "https://opensource-demo.orangehrmlive.com/web/images/orangehrm-logo.png?v=1689053487449";
    	String expectedSrcText = "orangehrm-logo.png";
    	if(actualSrcText.contains(expectedSrcText)) {
    		assertion.assertTrue(true, "Brand logo is as expected, actual image src is"+actualSrcText+", expected image src is "+expectedSrcText); //test step pass
    	}else {
    		assertion.assertTrue(false, "Brand logo is not as expected, actual image src is "+actualSrcText+", but expected image src is "+expectedSrcText); //fail 
    	}

		//2st validation  	
    	String actualDashboadText = webActions.getText(dashboardText);
    	String expectedDashboadText = "Dashboard";
    	
    	assertion.assertEquals(actualDashboadText, expectedDashboadText, "Actual dashboard text is "+actualDashboadText+", expected dashboard text is "+expectedDashboadText);
   
	}
    
    
    
    
    
    
    
    
    
    
    
    
}
