package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		
		WebElement frameElement1 = driver.findElement(By.xpath("/html/body/input"));
		frameElement1.sendKeys("Name");
		
		WebElement frameElement2 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frameElement2);
		driver.findElement(By.id("a")).click();
		
		driver.switchTo().defaultContent();
		WebElement frameElement3 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frameElement3);
		WebElement framedropdown=driver.findElement(By.id("animals"));
		Select dd=new Select(framedropdown);
		dd.selectByIndex(2);
		
}
}
