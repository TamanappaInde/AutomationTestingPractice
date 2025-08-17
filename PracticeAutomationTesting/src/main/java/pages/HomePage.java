package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// click on My Account link
	@FindBy(id = "menu-item-50")
	private WebElement myaccountLink;
	
	public void clickMyAccount() {
		myaccountLink.click();
	}
	
	// click on shop menu
	@FindBy(xpath="//*[text()='Shop']")
	private WebElement shopMenu;
	@FindBy(xpath="//*[text()='Home']")
	private WebElement homeMenu;
	public void clickonShopmenu() {
		shopMenu.click();
	
	}
	public void clickonHomemenu() {
		homeMenu.click();
	}
	
	
}
