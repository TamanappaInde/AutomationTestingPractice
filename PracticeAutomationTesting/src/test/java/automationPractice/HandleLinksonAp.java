package automationPractice;

import java.net.*;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleLinksonAp {
	
	WebDriver driver;
	
	@Test
	public void verifylinks() {
		
		try {
			driver = new ChromeDriver();
			
			driver.get("https://practice.automationtesting.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			// Step 1. Get all links on page and store into list 
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Total Links: " + links.size());
			// Step 2. Get the link text and url and print
			for (WebElement link : links) {
				String linkText = link.getText();
				String url = link.getAttribute("href");
				System.out.println("Linke Text : " + linkText + " URL: " + url);
				
				// Step 3. Print if url is null or skipped
				if (url == null || url.isEmpty()) {
					System.out.println("Skipped or null ");
					continue;
				}
				// Step 4. User HttpURLConnection interface and verify the links which are broken and which working
				try {
					HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
					conn.setRequestMethod("HEAD");
					conn.connect();
					
					int responseCode = conn.getResponseCode();
					if (responseCode >= 200 && responseCode < 400) {
						System.out.println("Working " + url + " Response: " + responseCode);
					} else {
						System.out.println("Broken " + url + " Response: " + responseCode);
					}
					
				} catch(Exception e) {
					System.out.println(e.toString());
				}
			}
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
