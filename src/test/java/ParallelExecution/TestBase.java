package ParallelExecution;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	
	BrowserFactory bf=new BrowserFactory();
	
	@BeforeMethod
	public void launchApplication() throws Exception
	{
		String browser=PropertiesClass.getPropertyvalue("browser");
		String url=PropertiesClass.getPropertyvalue("url");
		
		ThreadSample.getInstance().setDriver(bf.createBrowserInstance(browser));
		WebDriver driver = ThreadSample.getInstance().getDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to(url);
		
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
	   ThreadSample.getInstance().closeBrowser();	
	}

}
