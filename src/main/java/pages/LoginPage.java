package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {
	private WebDriver driver;

	// Page Factory
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginButton;
	
	/*
	private By emailTextbox = By.id("Email");
	private By passwordTextbox = By.id("Password");

	private By loginButton = By.xpath("//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button");
	*/
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String email) {
		emailTextbox.clear();
		emailTextbox.sendKeys(email);
		/*
		driver.findElement(emailTextbox).clear();
		driver.findElement(emailTextbox).sendKeys(email);
		*/
	}

	public void enterPassword(String password) {
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
		/*
		driver.findElement(passwordTextbox).clear();
		driver.findElement(passwordTextbox).sendKeys(password);
		*/	
	}

	public void clickLogin() {
		Log.info("Clicking login button..");
		loginButton.click();
		//driver.findElement(loginButton).click();
	}
}
