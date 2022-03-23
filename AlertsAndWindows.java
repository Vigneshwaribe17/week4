package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndWindows {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//Alert alert = driver.switchTo().alert();
	//alert.accept();
	driver.findElement(By.xpath("//div[@class='text-center col-xs-12']/button")).click();
	Thread.sleep(1000);
		
	driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
	//String currentWindowHandle = driver.getWindowHandle();
	//System.out.println(currentWindowHandle);
	
	Set<String> windows = driver.getWindowHandles();
	List<String> windows1 = new ArrayList<String>(windows);
	
	driver.switchTo().window(windows1.get(1));
	
	driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
	//Select cust = new Select(dropDown);
	//String text = cust.selectByIndex(2);
	String cut = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).getText();
	System.out.println(cut);
	driver.switchTo().window(windows1.get(0));
	driver.close();
	
		
	}
}
