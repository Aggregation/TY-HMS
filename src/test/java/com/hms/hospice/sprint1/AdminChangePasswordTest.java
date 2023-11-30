package com.hms.hospice.sprint1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hms.hospice.GenericUtils.BaseClass;
import com.hms.hospice.GenericUtils.DatabaseUtils;
import com.hms.hospice.GenericUtils.ExcelUtils;
import com.hms.hospice.GenericUtils.FileUtils;
import com.hms.hospice.GenericUtils.JavaUtils;
import com.hms.hospice.GenericUtils.WebdriverUtils;
import com.objectRepository.AdminDashboardPage;
import com.objectRepository.AdminLoginPage;
import com.objectRepository.Admin_ChangePasswordPage;
import com.objectRepository.HomePage;

//@Listeners(com.hms.hospice.GenericUtils.ListenerImplementationClass.class)
public class AdminChangePasswordTest extends BaseClass{
	//public static void main(String[] args) throws Throwable {
		
		/*WebdriverUtils wu=new WebdriverUtils();
		FileUtils fu=new FileUtils();
		ExcelUtils eu=new ExcelUtils();
		JavaUtils ju=new JavaUtils();
		DatabaseUtils du=new DatabaseUtils();
		
		String URL = fu.readDataFromPropertyFile("url");
		String AUN = fu.readDataFromPropertyFile("AdminUsername");
        String APWD = fu.readDataFromPropertyFile("AdminPassword");

		
		WebDriver driver=new ChromeDriver();
		wu.maximizeWindow(driver);
		
		
		wu.waitForPageLoad(driver, 6);
		
		driver.get(URL);
		
		HomePage home=new HomePage(driver);
		home.adminlinkClick();
		
	
		
		AdminLoginPage adminlogin=new AdminLoginPage(driver);
		adminlogin.adminlogin(AUN, APWD);*/ 
		
		@Test(retryAnalyzer = com.hms.hospice.GenericUtils.IRetryAnalyser.class)
	public void test1() throws Throwable {
		
		AdminDashboardPage adDash=new AdminDashboardPage(driver);
	
	    adDash.getProfileDD().click();
		
		adDash.getChangePassword_link().click();
		
		eu.readMultipleData("AdminChangePassword", driver);
		
		Admin_ChangePasswordPage adchangePass=new Admin_ChangePasswordPage(driver);
		
		adchangePass.getSubmitBtn().click();
		
	    String alert = wu.alertgetText(driver);
	    System.out.println(alert);
	   
		wu.alertAccept(driver);
		
		//Assert.fail();
		WebElement message = adchangePass.getConformMessage();
		String ConfirmMessage = message.getText();
		System.out.println(ConfirmMessage);
		

		
	}

}
