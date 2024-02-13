package ParallelExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
	
	//create webDriver object for given browser
	
	public WebDriver createBrowserInstance(String browser)
	{
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--incognito");
			driver=new ChromeDriver(option);
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
//			FirefoxOptions option=new FirefoxOptions();
//			option.addArguments("--private");
//			driver=new FirefoxDriver(option);
			driver=new FirefoxDriver();
		}
		return driver;
		
	}

}
