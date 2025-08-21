package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	public void clickonShopmenu() {
		shopMenu.click();
	
	}
	// click on home menu
	@FindBy(xpath="//*[text()='Home']")
	private WebElement homeMenu;
	public void clickonHomemenu() {
		homeMenu.click();
	}
	
	// verify three arrivals are present on home page
	@FindBy(css=".product a img")
	private List<WebElement> arrivals;
	public void verifyarrivals() {
		System.out.println("Arrivals Found: " + arrivals.size());
		Assert.assertEquals(arrivals.size(), 3,"Expected exactly three arrivals on home page");
	}
	
	// click on one arrival
	@FindBy(xpath="//img[@alt='Selenium Ruby']")
	private WebElement seleniumRuby;
	public void clickOnArrival() {
		seleniumRuby.click();
	}
	
	// verify that the after clicks on arrival image product details page is open
	@FindBy(xpath="//*[text()='Add to basket']")
	private WebElement addtobasket;
	public void verifyaddtobasketbutton() {
		addtobasket.isDisplayed();
	}
	public void clickonaddtobasket() {
		addtobasket.click();
	}
	
	// verify book added to basket sucessfully
	@FindBy(xpath="//*[text()=' “Selenium Ruby” has been added to your basket.']")
	private WebElement booktext;
	public void verifybookaddedsuccessfully() {
		String actualText = "[VIEW BASKET “Selenium Ruby” has been added to your basket.]";
		String expected = booktext.getText();
		Assert.assertEquals(actualText, expected,"Wrong book selected");
	}
}
