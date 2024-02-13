package com.hms.hospice.sprint1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.hms.hospice.GenericUtils.BaseClass;
import com.hms.hospice.GenericUtils.DatabaseUtils;
import com.hms.hospice.GenericUtils.ExcelUtils;
import com.hms.hospice.GenericUtils.FileUtils;
import com.hms.hospice.GenericUtils.IpathConstants;
import com.hms.hospice.GenericUtils.JavaUtils;
import com.hms.hospice.GenericUtils.WebdriverUtils;
import com.objectRepository.AdminDashboardPage;
import com.objectRepository.AdminLoginPage;
import com.objectRepository.Admin_ManageDoctorPage;
import com.objectRepository.HomePage;

public class DeleteDoctor  {
	
	@Test
	public void again() throws Throwable
	{
		DeleteDoctor d=new DeleteDoctor();
		int n=275;
		for(int i=1;i<=n;i++)
		{
			d.delete();
			
			
		}
	}
	
	
	
	
	
	@Test
	public void delete() throws Throwable
	{
		WebdriverUtils wu=new WebdriverUtils();
		FileUtils fu=new FileUtils();
		ExcelUtils eu=new ExcelUtils();
		DatabaseUtils du=new DatabaseUtils();
		JavaUtils ju=new JavaUtils();
		
		fu.readDataFromPropertyFile(IpathConstants.FILEPATH);
		String BROWSER = fu.readDataFromPropertyFile("browser");
		String URL = fu.readDataFromPropertyFile("url");
		String AUN=fu.readDataFromPropertyFile("AdminUsername");
	    String APWD=fu.readDataFromPropertyFile("AdminPassword");
	    
	    WebDriver driver=new ChromeDriver();
	    wu.maximizeWindow(driver);
	    driver.get(URL);
	    wu.implicitylyWait(driver, 5000);
	    HomePage home=new HomePage(driver);
	    home.adminlinkClick();
	    AdminLoginPage login=new AdminLoginPage(driver);
	    login.adminlogin(AUN, APWD);
	    AdminDashboardPage dash=new AdminDashboardPage(driver);
	    dash.getDoctor_submodule().click();
	    Thread.sleep(2000);
	    dash.getManageDoctor_link().click();
	    
//	    List<WebElement> butt = driver.findElements(By.xpath("//a[@tooltip=\"Remove\"]"));
//	   for(WebElement ele: butt)
//	   {
//		   ele.click();
//		   Thread.sleep(1000);
//		   driver.switchTo().alert().accept();
//		   System.out.println(ele+"------- deleted");
//	   }
	    try {
	    Admin_ManageDoctorPage manage=new Admin_ManageDoctorPage(driver);
	    manage.deletedoc(driver);
	    System.out.println("done");
	    }
	    catch (StaleElementReferenceException e) {
			// TODO: handle exception
	    	
		}
	    
	    driver.close();
	}

}
