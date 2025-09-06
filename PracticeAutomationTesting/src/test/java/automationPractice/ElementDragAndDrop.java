package automationPractice;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Point;




public class ElementDragAndDrop {
	
	WebDriver driver;
	
	@Test
	public void verifyDragAndDrop() {
		
		driver = new ChromeDriver();
		  driver.get("https://practice.automationtesting.in/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  driver.findElement(By.xpath("//*[text()='Demo Site']")).click();
		  driver.findElement(By.xpath("//a[@href='Interactions.html']")).click();
		  driver.findElement(By.xpath("//*[text()='Drag and Drop ']")).click();
		  driver.findElement(By.xpath("//*[text()='Static ']")).click();
		  
		
		  // locate elements
		  WebElement source = driver.findElement(By.xpath("//img[@src='logo.png']"));
		  WebElement target = driver.findElement(By.id("droparea"));
		  
		  // verification
		  Point initialLocation = source.getLocation();
		  
		  // create object of actions class
		  Actions actions = new Actions(driver);
		  actions.dragAndDrop(source, target).build().perform();
		  
		  // new location
		  Point newLocation = source.getLocation();
		  
		  // asser
		  Assert.assertNotEquals(initialLocation, newLocation);
		  
		  driver.close();
	}

}
