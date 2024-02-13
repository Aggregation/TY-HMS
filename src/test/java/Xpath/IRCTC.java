package Xpath;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class IRCTC {
	
	@Test
	public void book()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//a[text()=\" BUSES \"]")).click();
        String bus="https://www.bus.irctc.co.in/home";
		Set<String> wids = driver.getWindowHandles();
		for(String w: wids)
		{
			
			String cuurl = driver.switchTo().window(w).getCurrentUrl();
		
		    if(cuurl.equals(bus))
		    {
		    	driver.switchTo().window(w);
		    }
			
		}
	
		
		
		
		WebElement from = driver.findElement(By.xpath("//input[@name=\"departFrom\" and @id=\"departFrom\" ]"));
	    from.sendKeys("Bengaluru");
	    driver.findElement(By.xpath("//div[text()=\"Bengaluru\"]")).click();
	    
	    WebElement to = driver.findElement(By.xpath("//input[@id=\"goingTo\"]"));
	    to.sendKeys("Dharmapuri");
	    driver.findElement(By.xpath("//div[text()=\"Dharmapuri (Tamil Nadu)\"]")).click();
		
	    driver.findElement(By.xpath("//input[@id=\"departDate\"]")).click();
	    int date=24;
	    driver.findElement(By.xpath("//a[text()=\"24\"]")).click();
	    driver.findElement(By.xpath("//button[text()=\"Search Bus \"]")).click();
	    
	    driver.findElement(By.xpath("//div[@class=\"heading-02-wrap\"  and contains(.,\"Departure Time\")]/descendant::label[text()=\"After 6 pm\"]")).click();
	    
	    
	    
	}

}
