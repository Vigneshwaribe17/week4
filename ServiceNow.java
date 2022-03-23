package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
	
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://dev66971.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement frameElement = driver.findElement(By.name("gsft_main"));
		frameElement.click();
driver.switchTo().frame(frameElement);
driver.findElement(By.id("user_name")).sendKeys("admin");
driver.findElement(By.id("user_password")).sendKeys("5rpHtmS3BWRs");
driver.findElement(By.xpath("//button[text()='Log in']")).click();
driver.findElement(By.id("filter")).sendKeys("incident");
WebElement clickall = new WebDriverWait(driver, Duration.ofSeconds(30))
.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='All'])[2]")));
clickall.click();
WebElement frameElement1 = driver.findElement(By.name("gsft_main"));
frameElement1.click();
driver.switchTo().frame(frameElement1);
WebElement newbutton = new WebDriverWait(driver, Duration.ofSeconds(30))
.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='New']")));
newbutton.click();


driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
Set<String> windowhandles = driver.getWindowHandles();
List<String> windowhandlesList=new ArrayList<String>(windowhandles);
//to print the total window handle number
System.out.println("Total window number: " + windowhandlesList.size() + "\n");
System.out.println(windowhandles);
//switch to the second window
driver.switchTo().window(windowhandlesList.get(1));
//Get the current window's handle and write to the console window. It must be second window handle.
//System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
WebElement systemadmin = driver.findElement(By.linkText("System Administrator"));
systemadmin.click();
driver.switchTo().window(windowhandlesList.get(0));

WebElement frameElement2 = driver.findElement(By.name("gsft_main"));
frameElement2.click();
driver.switchTo().frame(frameElement2);

driver.findElement(By.xpath("(//input[@id='incident.short_description'])[1]")).sendKeys("Hi this is a new incident");
driver.switchTo().defaultContent();
WebElement frameElement3 = driver.findElement(By.name("gsft_main"));
frameElement3.click();
driver.switchTo().frame(frameElement3);
String text = driver.findElement(By.xpath("//input[@id='incident.number']")).getText();
System.out.println(text);

	}

	

}
