package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(" https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro"+Keys.ENTER);

		//WebElement getPrice=driver.findElement(By.xpath("((//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]//following::span[@class='a-offscreen'])[1]"));
		
		WebElement getPrice=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String priceOfFirst = getPrice.getText();
		System.out.println("The first phone price is"+priceOfFirst);
		
		//driver.findElement(By.xpath("//i[@class='a-icon a-icon-popover'])[1]")).click();
		WebElement getRate=driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
		
		System.out.println("the number of customer rating is"+getRate.getText()); 
		
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom'])[1]")).click();
		
		WebElement getPercentageRating=driver.findElement(By.xpath("(//a[@title='5 stars represent 65% of rating'])[3]"));

		System.out.println("The percentage of 5 star rating is "+getPercentageRating.getText());
		
		driver.findElement(By.xpath("//span[contains(text(),'OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)')]")).click();

		Set<String> windows=driver.getWindowHandles();
		
		List<String> windows1 = new ArrayList<String>(windows);
		
		driver.switchTo().window(windows1.get(1));
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']")).click();
	     //System.out.println("The current url1:" +driver.getCurrentUrl()); 
	   
	     Thread.sleep(1000);
	     WebElement findElement = driver.findElement(By.xpath("//a[@id='nav-cart']"));
	     //System.out.println(findElement.getAttribute("href"));
	      findElement.click();
	     
	     String text3= driver.findElement(By.xpath("(//span[@class='currencyINR']/parent::span)[1]")).getText();
	     String replace1=text3.replace(",", "");
			Float x=Float.parseFloat(replace1);
			float y =64999.00f;
			//int y=Math.round(value1);
	          
	     System.out.println("The subtotal is "+x);
	     
	     
	      if(x==y){
	    	  
	    	  System.out.println("The price is same");
	      }
	      else
	      {
	    	  System.out.println("The price is not same");
	      }
	       
		




}

}
