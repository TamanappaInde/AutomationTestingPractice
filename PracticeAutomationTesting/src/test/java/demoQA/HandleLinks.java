package demoQA;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleLinks {

	WebDriver driver;

	@Test
	public void linksTest() {

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
			
			// click on links
			driver.findElement(By.xpath("//*[text()='Links']")).click();
			// get the all links available and verify that which are wroking and which are broken
			List<WebElement> alllinks = driver.findElements(By.tagName("a"));
			System.out.println("Total Links on Page : " + alllinks.size());
			for (WebElement link : alllinks) {
				String linkText = link.getText();
				String url = link.getAttribute("href");
				System.out.println("Text : " + linkText + " URL : " + url);
				
				if (url == null || url.isEmpty()) {
					System.out.println("Skipped or Null href");
					continue;
				}
				try {
					HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
					conn.setRequestMethod("HEAD");
					conn.connect();
					
					int responseCode = conn.getResponseCode();
					if (responseCode >= 200 && responseCode < 400) {
						System.out.println("Working: " + url + " ( Response: " + responseCode + " )");
					} else {
						System.out.println("Broken: " + url + " ( Response: " + responseCode + " )");
					}
				} catch(Exception e) {
					System.out.println(e.toString());
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
