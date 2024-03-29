package OHRM.Tests;

import org.testng.annotations.Test;

import OHRM.PageObjects.AdminUserManagementPage;
import OHRM.PageObjects.LoginPage;
import OHRM.utilities.WebActions;

public class AdminTest extends BaseClass{

	@Test
	public void adminTest() {
		AdminUserManagementPage adminump = new AdminUserManagementPage(driver);
		
		adminump.login(userName,password);
		System.out.println("Logged in to application");
		
        WebActions.waitForPageToLoad(driver);	
		captureScreenshot("loginSuccessfull");
		
		adminump.printAllMenuOptions();
		adminump.navigateToAdminPage();
		captureScreenshot("adminPage");
		adminump.searchUser("admin");
		System.out.println("Admin test completed");
	}
}
