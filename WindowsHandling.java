package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Demosalesmanager");
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementLoginButton = driver.findElement(By.className("decorativeSubmit"));
		elementLoginButton.click();
		WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		elementCRMSFA.click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li[4]")).click();
		WebElement lookupFrom=driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]"));
		lookupFrom.click();
		
		Set<String> windowhandles = driver.getWindowHandles();
		List<String> windowhandlesList=new ArrayList<String>(windowhandles);
		//to print the total window handle number
		System.out.println("Total window number: " + windowhandlesList.size() + "\n");
		System.out.println(windowhandles);
		//switch to the second window
		driver.switchTo().window(windowhandlesList.get(1));
		//Get the current window's handle and write to the console window. It must be second window handle.
       // System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
		WebElement firstresultingcontact = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
		firstresultingcontact.click();
		driver.switchTo().window(windowhandlesList.get(0));
		WebElement lookupTo=driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]"));
		lookupTo.click();
		Set<String> windowhandles1 = driver.getWindowHandles();
		List<String> windowhandlesList1=new ArrayList<String>(windowhandles1);
		//to print the total window handle number
		System.out.println("Total window number: " + windowhandlesList1.size() + "\n");
		System.out.println(windowhandles1);
		//switch to the second window
		driver.switchTo().window(windowhandlesList1.get(1));
		
		WebElement secondresultingcontact = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[2]"));
		secondresultingcontact.click();
		driver.switchTo().window(windowhandlesList1.get(0));
		driver.findElement(By.xpath("//table[@class='twoColumnForm']//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());

}

}
