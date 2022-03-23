package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions2 {
	
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("http://www.leafground.com/pages/drop.html");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			WebElement drag = driver.findElement(By.id("draggable"));
			//Point location = element.getLocation();
			//int x = location.getX();
			//int y = location.getY();
			WebElement drop = driver.findElement(By.id("droppable"));
			Actions builder = new Actions(driver);
			
			builder.dragAndDrop(drag,drop).perform();
			
			
	}
}
