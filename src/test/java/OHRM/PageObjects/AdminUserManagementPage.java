package OHRM.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import OHRM.utilities.AssertionUtils;
import OHRM.utilities.WebActions;

public class AdminUserManagementPage {

    private final WebDriver driver;
    private final WebActions webActions;
    public final AssertionUtils assertion;

   
    public AdminUserManagementPage(WebDriver driver) {
        this.driver = driver;
        this.webActions = new WebActions(driver);
        this.assertion = new AssertionUtils();
    }

    
    //login page objexts
    By usernameInput = By.name("username");
    By passwordInput = By.name("password");
    By loginButton = By.xpath("//*[text()=' Login ']");
    
    //page objects
    String optionXpath = "//span[text()='dynamicValue']";
    By menuOptions;
    By menuAllOptions = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']");  
    By searchUnameInput = By.xpath("//*[text()='Username']/ancestor::div[contains(@class,'oxd-grid-item')]//input");
    By seachButton = By.xpath("//*[@type='submit']");
    By recordsText = By.xpath("//*[contains(@class,'orangehrm-horizontal-padding')]");
    
    
    
    public void login(String username, String password) {
    	 System.out.println("Navigating to the login page: https://opensource-demo.orangehrmlive.com/");
         driver.get("https://opensource-demo.orangehrmlive.com/");
         WebActions.waitForPageToLoad(driver);
         webActions.sendKeys(usernameInput, username);
         webActions.sendKeys(passwordInput, password);
         webActions.click(loginButton);
         webActions.waitForSeconds(5);
    }
    
    public void printAllMenuOptions() {
    	List<WebElement> options= driver.findElements(menuAllOptions);
    	for(int i=0;i<options.size();i++) {
    		System.out.println("Option "+(i+1)+" is "+options.get(i).getText());
    	}
    }
    
    
    public void navigateToAdminPage() {
    	optionXpath.replace("dynamicValue", "Admin");
    	menuOptions = By.xpath(optionXpath);
    	webActions.click(menuOptions);
    }
    
    public void navigateToPIM() {
    	optionXpath.replace("dynamicValue", "PIM");
    	menuOptions = By.xpath(optionXpath);
    	webActions.click(menuOptions);
    }
    
    public void navigateToLeave() {
    	optionXpath.replace("dynamicValue", "Leave");
    	menuOptions = By.xpath(optionXpath);
    	webActions.click(menuOptions);
    }
    
    
    public void searchUser(String userName) {
    	webActions.sendKeys(searchUnameInput,userName);
    	webActions.click(seachButton);
    	String recordsFound = webActions.getText(recordsText);
    	System.out.println(recordsFound);
    	
    	int actualCount =  Integer.parseInt(recordsFound.substring(1, 2)); //typecast string to int
//    	String actualName =  String.valueOf(1233232); //typecast int to string
    	assertion.assertEquals(actualCount, 1, recordsFound);    	
    }
    
    
    
    
    
    
    
    
    
    
}
