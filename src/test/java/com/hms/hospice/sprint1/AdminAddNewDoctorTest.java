package com.hms.hospice.sprint1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hms.hospice.GenericUtils.DatabaseUtils;
import com.hms.hospice.GenericUtils.ExcelUtils;
import com.hms.hospice.GenericUtils.FileUtils;
import com.hms.hospice.GenericUtils.IpathConstants;
import com.hms.hospice.GenericUtils.JavaUtils;
import com.hms.hospice.GenericUtils.WebdriverUtils;
import com.objectRepository.Add_DoctorPage;
import com.objectRepository.AdminDashboardPage;
import com.objectRepository.AdminLoginPage;
import com.objectRepository.DoctorDashBoardPage;
import com.objectRepository.DoctorLoginPage;
import com.objectRepository.HomePage;

public class AdminAddNewDoctorTest {
	
	public static void main(String[] args) throws Throwable {
		
		WebdriverUtils wu=new WebdriverUtils();
		FileUtils fu=new FileUtils();
		ExcelUtils eu=new ExcelUtils();
		JavaUtils ju=new JavaUtils();
		DatabaseUtils du=new DatabaseUtils();
		
		
		fu.readDataFromPropertyFile(IpathConstants.FILEPATH);
		String BROWSER = fu.readDataFromPropertyFile("browser");
		String URL = fu.readDataFromPropertyFile("url");
		String DUN = fu.readDataFromPropertyFile("DoctorUsername");
		String DPWD = fu.readDataFromPropertyFile("DoctorPassword");
		String AUN=fu.readDataFromPropertyFile("AdminUsername");
		String APWD =fu.readDataFromPropertyFile("AdminPassword");
		
		
 
		int rdm = ju.getRandomNo();
		
		 
		
		
		WebDriver driver=new ChromeDriver();
		wu.maximizeWindow(driver);
		
		driver.get(URL);
		
		wu.waitForPageLoad(driver, 7);
		
		
		HomePage home=new HomePage(driver);
		home.adminlinkClick();
		AdminLoginPage adminLogin=new AdminLoginPage(driver);
		adminLogin.adminlogin(AUN, APWD);
		
		AdminDashboardPage dashboardPage=new AdminDashboardPage(driver);
		dashboardPage.getDoctor_submodule().click();
	     wu.waituntilEleToBeclickable(driver, dashboardPage.getAddDoctor_link(), 3);
		dashboardPage.getAddDoctor_link().click();
		

	    eu.readMultipleData("AddDoctor", driver);

	   
//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestDataHospice.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("AddDoctor");
//		int count=sh.getLastRowNum();
	  
	   // String e=sh.getRow(0).getCell(4).getStringCellValue()+rdm;
	    
	    String email = eu.readDatafromExcel("AddDoctor", 0, 4);
	  //  System.out.println(email);
	    String randomEmail = email+rdm;
	    
	    Add_DoctorPage addDoc=new Add_DoctorPage(driver);
	    addDoc.getDocEmailTF().sendKeys(randomEmail);
	    
	    
		//WebElement email = driver.findElement(By.name("docemail"));
	    
//	    email.sendKeys(e);
		 
		    
   
	
	    
	 //  Add_DoctorPage addDoc=new Add_DoctorPage(driver);
	   WebElement speclizationDD = driver.findElement(By.name("Doctorspecialization"));
	   
	   wu.selectByVisibleTextDD(speclizationDD, "Homeopath");
	  
	  // addDoc.getDoctorspecDD().click();
	   
	   
	   addDoc.getSubmitBtn().click();
	
	   
	   String AlerMessage = driver.switchTo().alert().getText();
	   System.out.println(AlerMessage);
	   driver.switchTo().alert().accept();
	
	   
	   
	   dashboardPage.getProfileDD().click();
	   dashboardPage.getLogout_link().click();
	   

	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	   wait.until(ExpectedConditions.urlContains(URL));//link
	   
	   home.doctorlinkClick();

	  
	  DoctorLoginPage docLogin=new DoctorLoginPage(driver);
	  docLogin.getDoctor_UN().sendKeys(DUN);
	  docLogin.getDoctor_PWD().sendKeys(DPWD);
	  docLogin.getSubmit_Btn().click();
	   

		
	  DoctorDashBoardPage docDash=new DoctorDashBoardPage(driver);
	  docDash.getProfileDD().click();
	  docDash.getDLogout_link().click();

		
	   
	   
	   
		
		
		
		
		
	}
	

}
