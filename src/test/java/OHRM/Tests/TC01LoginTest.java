package OHRM.Tests;

import org.testng.annotations.Test;

import OHRM.PageObjects.LoginPage;

public class TC01LoginTest extends BaseClass{

	@Test
	public void loginTest() {
		System.out.println("This is a login test method");
		LoginPage loginPage = new LoginPage(driver);

        // Example usage
        loginPage.login("admin", "admin123");
		captureScreenshot("loginTest");
		
		
	}
}
