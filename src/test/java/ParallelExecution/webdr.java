package ParallelExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class webdr {
	@Test
	public void demo()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		ChromeDriver driver1=new ChromeDriver();
		
	}

}
