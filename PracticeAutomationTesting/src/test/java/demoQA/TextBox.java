package demoQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TextBox {

	WebDriver driver;
	
	@Test
	public void textboxTest() {
		
		try {
			driver = new ChromeDriver();
			driver.get("https://demoqa.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			// click on elements
			WebElement elements = driver.findElement(By.xpath("//*[text()='Elements']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", elements);
			elements.click();
			
			driver.findElement(By.xpath("//*[text()='Text Box']")).click();
			// Enter Text using JavaScript Executor
			WebElement fullName = driver.findElement(By.id("userName"));
			js.executeScript("arguments[0].value='Tamanappa Inde'", fullName);
			WebElement usermail = driver.findElement(By.id("userEmail"));
			js.executeScript("arguments[0].value='inde@gmail.com'", usermail);
			WebElement currentAddress = driver.findElement(By.id("currentAddress"));
			js.executeScript("arguments[0].value='Ravet Pune 412101'", currentAddress);
			WebElement permanent = driver.findElement(By.id("permanentAddress"));
			js.executeScript("arguments[0].value='Omerga Dharashiv 413606'", permanent);
//		
			//WebElement button = driver.findElement(By.id("submit"));
//			js.executeScript("arguments[0].scrollIntoView(true)", button);
//			button.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
			button.click();
			
			
			// 
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
