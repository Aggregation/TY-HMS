package Xpath;

import java.time.Duration;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class angelone {
	
	@Test
	public void mouseover()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.angelone.in/");
		WebElement trade = driver.findElement(By.xpath("//li[@id=\"menu-item-457564\"]"));
		Actions action=new Actions(driver);
		action.moveToElement(trade).pause(2000).click(driver.findElement(By.xpath("//a[text()=\"Stocks\" and @title=\"Stocks\"]"))).perform();
		
		//driver.findElement(By.xpath("//input[@id=\"sector-filter-search\"]")).click();
		
		WebElement mid = driver.findElement(By.xpath("//span[text()=\"Mid Cap\"]"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		int y=mid.getLocation().getY();
		jse.executeScript("(window.scrollBy(0,"+y+"))", mid);
		
		List<WebElement> name = driver.findElements(By.xpath("//table/tbody/tr[*]/td/p[@class=\"company-short-name\"]"));
	    for(WebElement ele: name)
	    {
	    	String n=ele.getText();
	    	System.out.println(n);
	    }
	}
	
	@Test
	public void next()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.angelone.in/");
		WebElement menu = driver.findElement(By.xpath("//li[@id=\"menu-item-457568\"]"));
		Actions action=new Actions(driver);
		//action.moveToElement(menu).pause(2000).click(driver.findElement(By.xpath("//a[text()=\"AMCs\"]"))).perform();
		action.moveToElement(menu, 800, 500).contextClick().perform();
		
		
	}

}
