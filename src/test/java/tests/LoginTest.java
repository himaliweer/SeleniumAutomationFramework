package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException {

		String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];

		for (int i = 1; i < rowCount; i++) {

			data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Email
			data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Password
		}
		ExcelUtils.closeExcel();
		return data;
	}

	@DataProvider(name = "LoginData2")
	public Object[][] getData() {

		return new Object[][] { { "user1", "pass1" }, { "user2", "pass2" }, { "user3", "pass3" } };
	}

	// @Test(dataProvider = "LoginData2")
	// @Test(dataProvider = "LoginData")
	 
	/*
	@Test
	@Parameters({"username","password"})
	
	 public void testValidLogin(String Email, String Password) {
	*/
	@Test
	 public void testValidLogin() {
		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test - ");

		LoginPage loginPage = new LoginPage(driver);
		test.info("Navigating to URL");
		Log.info("Adding credentials");

		 
		loginPage.enterEmail("admin@yourstore.com");
		loginPage.enterPassword("admin");
		 

		/*
		loginPage.enterEmail(Email);
		loginPage.enterPassword(Password);
		*/
		loginPage.clickLogin();

		test.info("Clicking on Login button");

		System.out.println("Title of the page is: " + driver.getTitle());
		Log.info("Verifying page title");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");

		test.pass("Login Successful");
	}

	/*
	 * @Test public void testValidLogin() {
	 * 
	 * Log.info("Starting login test..."); test =
	 * ExtentReportManager.createTest("Login Test - ");
	 * 
	 * LoginPage loginPage = new LoginPage(driver); test.info("Navigating to URL");
	 * Log.info("Adding credentials");
	 * 
	 * loginPage.enterEmail("admin@yourstore.com");
	 * loginPage.enterPassword("admin");
	 * 
	 * loginPage.clickLogin();
	 * 
	 * test.info("Clicking on Login button");
	 * 
	 * System.out.println("Title of the page is: " + driver.getTitle());
	 * Log.info("Verifying page title"); test.info("Verifying page title");
	 * Assert.assertEquals(driver.getTitle(), "Just a moment...");
	 * 
	 * test.pass("Login Successful"); }
	 */

}
