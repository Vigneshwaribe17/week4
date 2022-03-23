package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions3 {
	

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.leafground.com/pages/selectable.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement element1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement element2 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement element3 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		//Point location = element.getLocation();
		//int x = location.getX();
		//int y = location.getY();
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(element1).click(element2).click(element3)
		.perform();
		
	}
}
