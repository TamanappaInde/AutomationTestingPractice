package WebTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {
	
	WebDriver driver;
	
	@Test
	public void webtableTest() {
		
		try {
			driver = new ChromeDriver();
			
			driver.get("https://demoqa.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			WebElement elements = driver.findElement(By.xpath("//*[text()='Elements']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", elements);
			elements.click();
			
			//click on web tables
			driver.findElement(By.xpath("//*[text()='Web Tables']")).click();
			
			// get column headers
			List<WebElement> headers = driver.findElements(By.xpath("//div[@class='rt-thead -header']"));
			System.out.println("Total Columns: " + headers.size());
			for (WebElement header : headers) {
				//System.out.println(header.getText());
			}
			
			// get the particular data from first colmn
			WebElement firstname = driver.findElement(By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-tr -odd']//div[@class='rt-td'][1]"));
			System.out.println(firstname.getText());
			
			// Get All rows
//			List<WebElement>  rows = driver.findElements(By.cssSelector(".ReactTable .rt-tbody .rt-tr-group"));
//			System.out.println("Total Rows: " + rows.size());
			
			// Get All columns
//            for (int i=1; i <=rows.size();i++) {
//            	// Get all columns
//            	List<WebElement> cols = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group'][\" + i + \"]/div/div"));
//            	System.out.println("Row " + i + ": ");
//            	for (WebElement col : cols) {
//            		System.out.print(col.getText() + "\n");
//            		
//            	}
//            	//System.out.println();
//            }
//			for (WebElement row : rows) {
//				List<WebElement> cells = row.findElements(By.cssSelector(".ReactTable .rt-td"));
////				for (WebElement cell : cells) {
////					System.out.println(cell.getText() + " | ");
////				}
//				if(!cells.isEmpty()) {
//					System.out.println(cells.get(0).getText());
//				}
//			}
			
			
			driver.close();
			// click on web tables
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
		
	}

}
