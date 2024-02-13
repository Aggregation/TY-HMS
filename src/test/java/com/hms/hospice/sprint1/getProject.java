package com.hms.hospice.sprint1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class getProject {
	@Test
	public void test()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

}
