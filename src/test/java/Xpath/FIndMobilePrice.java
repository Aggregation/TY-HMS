package Xpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FIndMobilePrice {
	
	@Test
	public void find() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement sear=driver.findElement(By.xpath("//input[@name=\"q\"]"));
		sear.click();
		sear.sendKeys("i phone 14");
		sear.sendKeys(Keys.ENTER);
		
		List<WebElement> name = driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]/ancestor::div[@class=\"_3pLy-c row\"]/descendant::div[@class=\"_30jeq3 _1_WHN1\"]"));
		for(int i=0;i<price.size();i++)
		{
			
		}
	}

}
