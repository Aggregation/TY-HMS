package Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class Goibibo {
	
	@Test
	public void find() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[@class=\"sc-gsFSXq bGTcbn\"]")).click();
		 driver.findElement(By.xpath("//span[text()=\"From\"]/parent::div[@class=\"sc-12foipm-16 wRKJm fswFld \"]")).click();
		 Thread.sleep(2000);
		WebElement from = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		from.click();
		from.sendKeys("ben");
		driver.findElement(By.xpath("//span[text()=\"Bengaluru, India\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"To\"]/parent::div[@class=\"sc-12foipm-16 wRKJm fswFld \"]")).click();
		Thread.sleep(2000);
		WebElement to=driver.findElement(By.xpath("//input[@type=\"text\"]"));
		to.click();
		to.sendKeys("chennai");
		to.sendKeys(Keys.ENTER);
		
		
		
		
		
		
		
		
	}

}
