package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// verify the login page is successfully open
	@FindBy (id = "username")
	private WebElement usernamefield;
	public boolean  isloginpagedisplayed() {
		return usernamefield.isDisplayed();
	}
	// user enters username and password
	public void enterUsername(String username) {
		usernamefield.sendKeys(username);
	}
	// user enters password
	@FindBy (id = "password")
	private WebElement passwordfield;
	public void enterPassword(String pass) {
		passwordfield.sendKeys(pass);
	}
	// click on login button
	@FindBy (name = "login")
	private WebElement loginbutton;
	public void clickonLoginbutton() {
		loginbutton.click();
	}
	// verify login successful
	@FindBy (xpath = "//a[text()='Sign out']")
	private WebElement signoutlink;
	public void verifyloginsuccessfull() {
		String expectedText = "Sign out";
		String actualText = signoutlink.getText();
		Assert.assertEquals(actualText, expectedText, "Login was not successful");
	}
	
	// verify error after enter invalid credentials
	@FindBy (xpath = "//ul[@class='woocommerce-error']")
	private WebElement errormessage;
	public void verifyErrorMessage(String expectedError) {
		String actualError = errormessage.getText();
		Assert.assertEquals(actualError, expectedError, "Login was not successful");
	}
}
