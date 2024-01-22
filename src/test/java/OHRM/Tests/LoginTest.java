package OHRM.Tests;

import org.testng.annotations.Test;

import OHRM.PageObjects.LoginPage;
import OHRM.utilities.WebActions;

public class LoginTest extends BaseClass{

	
	@Test
	public void loginTest() {
		System.out.println("This is a login test method");
		LoginPage loginPage = new LoginPage(driver);

        // Example usage
        loginPage.login("admin", "admin123");
        WebActions.waitForPageToLoad(driver);	
		captureScreenshot("loginTest");
		loginPage.validateLogin();
		
	}
}
