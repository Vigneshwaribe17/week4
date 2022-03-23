package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		

		String currentWindowHandle = driver.getWindowHandle();
		System.out.println(currentWindowHandle);

		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
				
		
		Set<String> allWindowHandleSet = driver.getWindowHandles();
		
		List<String> allWindowHandleList = new ArrayList<String>();
		allWindowHandleList.addAll(allWindowHandleSet);
		
		
		String newWindow = allWindowHandleList.get(1);
		
		// Switching to the new window
		driver.switchTo().window(newWindow);
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		
		driver.switchTo().window(allWindowHandleList.get(0));
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		driver.switchTo().window(allWindowHandleList.get(1));
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(allWindowHandleList.get(0));
		driver.findElement(By.xpath("//a[text() ='Merge']")).click();
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		System.out.println(text);
		alert.accept();
		
		
		
		
		
	}

}
