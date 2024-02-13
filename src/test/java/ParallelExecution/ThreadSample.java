package ParallelExecution;

import org.openqa.selenium.WebDriver;

public class ThreadSample {
	
	//singleton design pattern 
	private ThreadSample()
	{
		
	}
	
	private static ThreadSample instance=new ThreadSample();
	
	
	//getter method to access the object form outside class
	public static ThreadSample getInstance()
	{
		return instance;
	}
	

	//factory design pattern
    ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
    
	public WebDriver getDriver()
	{
		return driver.get();
	}
	
	public void setDriver(WebDriver driverParam)
	{
		driver.set(driverParam);
	}
	
	public void closeBrowser()
	{
		driver.get().close(); // its belongs to webDriver methods
		driver.remove();
	}
	
	

}
