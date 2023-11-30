package com.hms.hospice.sprint1;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
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

import com.hms.hospice.GenericUtils.BaseClass;
import com.hms.hospice.GenericUtils.DatabaseUtils;
import com.hms.hospice.GenericUtils.ExcelUtils;
import com.hms.hospice.GenericUtils.FileUtils;
import com.hms.hospice.GenericUtils.IpathConstants;
import com.hms.hospice.GenericUtils.JavaUtils;
import com.hms.hospice.GenericUtils.WebdriverUtils;
import com.objectRepository.Add_DoctorPage;
import com.objectRepository.AdminDashboardPage;
import com.objectRepository.AdminEditDoctorDetailsPage;
import com.objectRepository.AdminLoginPage;
import com.objectRepository.Admin_ManageDoctorPage;
import com.objectRepository.HomePage;

public class AdminEditDoctorDetailsTest  {
	public static void main(String[] args) throws Throwable {
		
		FileUtils fu=new FileUtils();
		WebdriverUtils wu=new WebdriverUtils();
		DatabaseUtils du=new DatabaseUtils();
		JavaUtils ju=new JavaUtils();
		ExcelUtils eu=new ExcelUtils();
		
		fu.readDataFromPropertyFile(IpathConstants.FILEPATH);
		String BROWSER = fu.readDataFromPropertyFile("browser");
		String URL = fu.readDataFromPropertyFile("url");
		String DUN = fu.readDataFromPropertyFile("DoctorUsername");
		String DPWD = fu.readDataFromPropertyFile("DoctorPassword");
		String AUN=fu.readDataFromPropertyFile("AdminUsername");
		String APWD =fu.readDataFromPropertyFile("AdminPassword");
	

		 
		
		WebDriver driver=new ChromeDriver();
		wu.maximizeWindow(driver);
		wu.waitForPageLoad(driver, 5);
		
		driver.get(URL);
		HomePage home=new HomePage(driver);
		home.adminlinkClick();
		AdminLoginPage adlogin=new AdminLoginPage(driver);
		adlogin.adminlogin(AUN, APWD);
		
	
		AdminDashboardPage addashPage=new AdminDashboardPage(driver);
		addashPage.getDoctor_submodule().click();
		wu.implicitylyWait(driver, 4);
		addashPage.getManageDoctor_link().click();
		
		Admin_ManageDoctorPage manageAdmin=new Admin_ManageDoctorPage(driver);
		manageAdmin.getEditicon().click();
		
		
		
		String valueFetch = eu.readDatafromExcel("ConsultancyFees", 0, 1);
      //  eu.readMultipleData("ConsultancyFees", driver);
        
        AdminEditDoctorDetailsPage editpage=new AdminEditDoctorDetailsPage(driver);
        editpage.getConFessTF().clear();
        
       String valueUpdate = valueFetch+ju.getRandomNo();
        editpage.getConFessTF().sendKeys(valueUpdate);
		editpage.getSubmitBtn().click();
        
		
		WebElement message = editpage.getConfirmMessage();
		String UpdateMessage = message.getText();
		System.out.println(UpdateMessage);
		addashPage.getDoctor_submodule().click();
		addashPage.getManageDoctor_link().click();
		
		
		manageAdmin.getEditicon().click();
		//driver.findElement(By.xpath("//tr//td[3]/following-sibling::td/div/a[@href=\"edit-doctor.php?id=3\"]")).click();
		
		
		WebElement Uconfess = editpage.getConFessTF();
		
		String UpdateFees = Uconfess.getAttribute("value");
		Assert.assertEquals(UpdateFees, valueUpdate);
		
		//assert.assertEquals(UpdateMessage, valueUpdate);
		System.out.println(valueFetch+" Updated successfully "+UpdateFees);
		//System.out.println("Not updated");
		//System.out.println(UpdateFees);
//		if(UpdateFees.equals(valueFetch))
//		{
//			System.out.println(valueFetch+" Not updated "+UpdateFees);
//			
//		}
//		else
//		{
//			System.out.println(valueFetch+" Updated successfully "+UpdateFees);
//		}
        
		
		
	}

}
