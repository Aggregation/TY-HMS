package Xpath;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class shoecornival {
	
	@Test
	public void ro() throws AWTException
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.shoecarnival.com/");
		Robot robot=new Robot();
		
        for(int i=0;i<4;i++)
		{
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ADD);
		robot.keyRelease(KeyEvent.VK_ADD);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		}
        for (int i = 0; i < 10; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		
//
//        WebElement footer = driver.findElement(By.xpath("//p[text()=\" © 2024 Shoe Carnival, Inc. All Rights Reserved.\"]"));
//        
//		JavascriptExecutor jse=(JavascriptExecutor)driver;
//         int y=footer.getRect().getY();
//		jse.executeScript("window.scrollBy(0,"+y+")", footer);
//		
//		
//		//WebElement ele = driver.findElement(By.xpath("//div[@class=\"css-18nmmy default_cursor_cs\"]/descendant::a[text()=\"Vendor Code of Conduct\"]"));
////		WebElement ele = driver.findElement(By.xpath("//a[text()=\"About Us\"]"));
////		String text = ele.getText();
////		String url=driver.getCurrentUrl();
////		System.out.println(url);
////		System.out.println(text);
////		ele.click();
////		driver.navigate().back();
//		
//		List<WebElement> elems = driver.findElements(By.xpath("//div[@class=\"css-18nmmy default_cursor_cs\"]/descendant::a[@class=\"chakra-link css-q5lgkf\"]"));
//	    
//		for(int i=0;i<elems.size();i++)
//		{
//			String value=elems.get(i).getText();
//			System.out.println(value);
//		}
	
	
	}

}
