package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoOfFrames {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> frameNumber=driver.findElements(By.tagName("iframe"));
		
		//List<WebElement> frameCount = new ArrayList<WebElement>();
		//frameCount.addAll(frameNumber);
		System.out.println(frameNumber.size());
		
		//int count=0;
	//for (int i=0;i<frameNumber.size();i++)
	//{
		//count = count+frameNumber(i);
		//System.out.println("");
	//}
	}
}