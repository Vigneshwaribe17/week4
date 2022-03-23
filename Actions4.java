package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions4 {
	public static void main(String[] args) {
		
		
			WebDriverManager.chromedriver().setup();
			 ChromeDriver driver=new ChromeDriver();
			 driver.get("https://jqueryui.com/sortable/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			WebElement frameElement = driver.findElement(By.className("demo-frame"));
			frameElement.click();
	driver.switchTo().frame(frameElement);
	WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
	WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));



	Actions builder=new Actions(driver);
	builder.clickAndHold(item5).release(item1).perform();
		}
}
