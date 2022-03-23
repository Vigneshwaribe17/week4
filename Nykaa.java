package week4.day2;

import java.time.Duration;
import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		
		//launching chromebrowser by disabling notifications
				ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
Actions builder=new Actions(driver);
builder.moveToElement(brands).perform();
driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
driver.findElement(By.linkText("L'Oreal Paris")).click();

String title = driver.getTitle();
System.out.println(title.contains("L'Oreal"));
driver.findElement(By.xpath("//span[@class='sort-name']")).click();
driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
driver.findElement(By.xpath("//div[@class='filter-open css-1kwl9pj']")).click();
driver.findElement(By.xpath("(//div[@class=' css-b5p5ep'])[2]")).click();
driver.findElement(By.xpath("(//div[@class=' css-b5p5ep'])[1]")).click();
driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
driver.findElement(By.xpath("(//div[@class='filter-open css-1kwl9pj'])[6]")).click();
driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']/div[@class='control-indicator checkbox ']")).click();
String filter = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
if(filter.contains("Shampoo")) {
System.out.println(filter);
}
else {
System.out.println("NO");
}
WebElement Shampoo = new WebDriverWait(driver, Duration.ofSeconds(30))
.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='css-xrzmfa'])[1]")));
Shampoo.click();
//driver.findElement(By.xpath("")).click();
ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
//switch to new tab
driver.switchTo().window(newTb.get(1));

WebElement drop = driver.findElement(By.xpath("//select[@title='SIZE']"));
Select dd = new Select(drop);
dd.selectByIndex(1);
String mrp = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
System.out.println(mrp);
driver.findElement(By.xpath("(//button[@class=' css-n03g1c'])[1]")).click();
driver.findElement(By.xpath("//span[@class='cart-count']")).click();
WebElement frame = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
driver.switchTo().frame(frame);

String grandtotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
System.out.println(grandtotal);
driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
driver.findElement(By.xpath("//button[@class='btn full big']")).click();
String grandtotalguest = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
System.out.println(grandtotalguest);
if(grandtotal.equals(grandtotalguest)){
System.out.println("Both are same");
}else
{
System.out.println("Both are different");

}
driver.quit();
}	


}
		
		
