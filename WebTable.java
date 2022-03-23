package week4.day2;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebTable {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement tofindrows = driver.findElement(By.xpath("//table[@id='table_id']//tr"));
		List<WebElement> totalrows = driver.findElements(By.tagName("tr"));
		
		System.out.println(totalrows.size());
	
		WebElement tofindcols = driver.findElement(By.xpath("//table[@id='table_id']//tr/td"));
		List<WebElement> totalcols = driver.findElements(By.tagName("td"));
		
		System.out.println(totalcols.size());
		List<String> names=new ArrayList<String>();
		List<String> cmpnames=new ArrayList<String>();
		System.out.println("");
		for (int i = 1; i < totalrows.size(); i++) {
			WebElement eachRow = totalrows.get(i);
			WebElement tdColData = eachRow.findElements(By.tagName("td")).get(1);
			//System.out.println(tdColData.getText());
			names.add(tdColData.getText());
				}
		System.out.println("");
		System.out.println("Sorted by names header");
		driver.findElement(By.xpath("(//th[@class='sorting'])[1]")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//td[@class='sorting_1']"));
		for (int i = 0; i < findElements.size(); i++) {
			System.out.println(findElements.get(i).getText());
			cmpnames.add(findElements.get(i).getText());
		}
		System.out.println("");
		System.out.println("Final Comparison");
		for (int i = 0; i < cmpnames.size(); i++) {	
			if(cmpnames.get(i).equals(names.get(i)))
			{
			System.out.println(names.get(i));
			
		}	
		
		}
		}	
	

}
