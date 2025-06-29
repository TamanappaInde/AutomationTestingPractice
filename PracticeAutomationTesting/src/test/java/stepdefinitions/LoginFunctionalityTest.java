package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BaseClass;
import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;

public class LoginFunctionalityTest {

	WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;

	public LoginFunctionalityTest() {
		this.driver = BaseClass.getDriver(); // Reuse WebDriver from Hooks
		this.homepage = new HomePage(driver);
		this.loginpage = new LoginPage(driver);
	}

	@Given("User launches the application and is on the login page")
	public void user_launches_the_application_and_is_on_the_login_page() {
		driver.get("https://practice.automationtesting.in");
		homepage.clickMyAccount();
		Assert.assertTrue(loginpage.isloginpagedisplayed());
	}
	@Given("User enters valid {string} and {string}")
	public void user_enters_valid_and(String string, String string2) {
	    loginpage.enterUsername("indesuraj@gmail.com");
	    loginpage.enterPassword("Inde@4221");
	}
	@Given("User enters invalid email {string} and password {string}" )
	public void user_enters_invalid_email_and_password(String email, String password) {
	    loginpage.enterUsername(email);
	    loginpage.enterPassword(password);
	}
	@When("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
	    loginpage.clickonLoginbutton();
	}
	@Then("User should see the my profile page")
	public void user_should_see_the_my_profile_page() {
	    loginpage.verifyloginsuccessfull();
	}
	// Invalid verification
	@Then("User should see error message {string}")
	public void user_should_see_error_message_indicating_invalid_credentials(String expectedErrorMessage) {
	   loginpage.verifyErrorMessage(expectedErrorMessage);
	}
}
