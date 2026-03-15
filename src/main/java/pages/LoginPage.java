package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Log;

public class LoginPage {
	private WebDriver driver;

	private By emailTextbox = By.id("Email");
	private By passwordTextbox = By.id("Password");

	private By loginButton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmail(String email) {
		driver.findElement(emailTextbox).clear();
		driver.findElement(emailTextbox).sendKeys(email);

	}

	public void enterPassword(String password) {
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys(password);

	}

	public void clickLogin() {
		Log.info("Clicking login button..");
		driver.findElement(loginButton).click();
	}
}




