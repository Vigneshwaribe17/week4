package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitApperar {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
			WebDriverManager.chromedriver().setup();
			 ChromeDriver driver=new ChromeDriver();
			 driver.get("http://www.leafground.com/pages/appear.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			WebElement findElement = driver.findElement(By.id("btn"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(findElement));
			String text = findElement.getText();
			System.out.println(text);
			if(findElement.isDisplayed())
			{
				System.out.println("Button Visible");
			}
			else
			{
				System.out.println("Button disappear");
			}

		}

	
			
	}
	



