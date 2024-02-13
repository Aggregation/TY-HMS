package ParallelExecution;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class crossbrowserWithoutXML {
	

	public WebDriver driver2;
	public WebDriver driver;
	
	@BeforeClass
	public void browserall()
	{
	     driver=new ChromeDriver();
		driver2=new FirefoxDriver();
	}
	
	@Test
	public void run()
	{   driver.manage().window().maximize();
	    driver.get("https://www.amazon.in");
		driver2.manage().window().maximize();
		driver2.get("https://www.amazon.in/");
	
		
	}
	@Test
	public void browser()
	{
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your browser");
		String text=s.next();
		
		WebDriver driver=null;
		if(text.equalsIgnoreCase("chrome"))
		{
		   driver=new ChromeDriver();
		}
		else if(text.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		
		
	}
	
	@Test
	public void map()
	{
		HashMap<String , String> map=new HashMap<String, String>();
		map.put("Browser1", "chrome");
		map.put("Browser2","firefox");
		
		WebDriver driver=null;
		for(Entry<String, String> b:map.entrySet())
		{			
			if(b.getValue().equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}
			if(b.getValue().equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
				
		}
		driver.manage().window().maximize();
	}

	
	
	
	

}
