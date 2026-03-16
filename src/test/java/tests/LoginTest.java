package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest{
	
	@Test
	public void testValidLogin() {
		
		Log.info("Starting login test..."); 
		test = ExtentReportManager.createTest("Login Test - ");

		LoginPage loginPage = new LoginPage(driver);
		test.info("Navigating to URL");
		Log.info("Adding credentials");
		
		
		loginPage.enterEmail("admin@yourstore.com");
		loginPage.enterPassword("admin");
		
		loginPage.clickLogin();
		
		test.info("Clicking on Login button");
		
		System.out.println("Title of the page is: " +driver.getTitle());
		Log.info("Verifying page title");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment... 123");
		
		test.pass("Login Successful");
	}
	
}





