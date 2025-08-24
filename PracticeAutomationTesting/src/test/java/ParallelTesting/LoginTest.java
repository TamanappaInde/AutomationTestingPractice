package ParallelTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver driver;
	
	@Parameters({"browser","username","password"})
	@Test
	public void loginTest(String browser, String username, String password) {
		// launch browser
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://practice.automationtesting.in/");
		// click on my account
		driver.findElement(By.xpath("//*[text()='My Account']")).click();
		// enetr username
		driver.findElement(By.id("username")).sendKeys(username);
		// enter password
		driver.findElement(By.id("password")).sendKeys(password);
		// click on login button
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		// validation
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		
		
	}

}
