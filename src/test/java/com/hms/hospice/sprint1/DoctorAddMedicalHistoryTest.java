package com.hms.hospice.sprint1;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hms.hospice.GenericUtils.DatabaseUtils;
import com.hms.hospice.GenericUtils.ExcelUtils;
import com.hms.hospice.GenericUtils.FileUtils;
import com.hms.hospice.GenericUtils.JavaUtils;
import com.hms.hospice.GenericUtils.WebdriverUtils;
import com.objectRepository.DocManagePatientPage;
import com.objectRepository.DoctorDashBoardPage;
import com.objectRepository.DoctorLoginPage;

import com.objectRepository.HomePage;
import com.objectRepository.PatientDashboardPage;
import com.objectRepository.PatientLoginPage;

import net.bytebuddy.asm.Advice.Enter;

public class DoctorAddMedicalHistoryTest {
	public static void main(String[] args) throws Throwable {
		
		FileUtils fu=new FileUtils();
		ExcelUtils eu=new ExcelUtils();
		WebdriverUtils wu=new WebdriverUtils();
		DatabaseUtils du=new DatabaseUtils();
		JavaUtils ju=new JavaUtils();
		
		String URL = fu.readDataFromPropertyFile("url");
		String DUN = fu.readDataFromPropertyFile("DoctorUsername");
		String DPWD = fu.readDataFromPropertyFile("DoctorPassword");
		String PUN = fu.readDataFromPropertyFile("PatientName");
		String PPWD = fu.readDataFromPropertyFile("PatientPassword");
		
		
		

		
		
		WebDriver driver=new ChromeDriver();
		
		wu.maximizeWindow(driver);
//		driver.manage().window().maximize();
		driver.get(URL);
		
		wu.waitForPageLoad(driver, 7);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		wu.waitUntilElemetToBeVisble(driver, , 0);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		HomePage home=new HomePage(driver);
		home.doctorlinkClick();
		
		//WebElement DoctorLoginlink = driver.findElement(By.xpath("//a[@href=\"hms/doctor/\"]"));
		//DoctorLoginlink.click();
		
		DoctorLoginPage doclogin=new DoctorLoginPage(driver);
		doclogin.getDoctor_UN().sendKeys(DUN);
		doclogin.getDoctor_PWD().sendKeys(DPWD);
		doclogin.getSubmit_Btn().click();
		
//		WebElement DusernameTF = driver.findElement(By.name("username"));
//		DusernameTF.click();
//		DusernameTF.sendKeys(DUN);
//		WebElement passwordTF = driver.findElement(By.name("password"));
//		passwordTF.click();
//		passwordTF.sendKeys(DPWD);
//		driver.findElement(By.name("submit")).click();
		
		DoctorDashBoardPage docDash=new DoctorDashBoardPage(driver);
		docDash.getPatients_submod().click();
		wu.waitUntilElemetToBeVisble(driver,docDash.getManagepatient_link() , 3);
		//Thread.sleep(2000);
		docDash.getManagepatient_link().click();
		
//		WebElement PatientDD = driver.findElement(By.xpath("//span[text()=\" Patients \"]"));
//		PatientDD.click();
//		WebElement ManagePatientLink = driver.findElement(By.xpath("//a[@href=\"manage-patient.php\"]"));
//		ManagePatientLink.click();
		
		
		DocManagePatientPage docManPatient=new DocManagePatientPage(driver);
		
		docManPatient.getEyeIcon().click();
		docManPatient.getAddMedicalHistoryBtn().click();
		
		
	
        Thread.sleep(2000);
		eu.readMultipleData("AddMedicalHistory", driver);
        wu.implicitylyWait(driver, 3);   
        docManPatient.getSubmitBtn().click();
		
	  
	   
		String alertText = wu.alertgetText(driver);
	   //String AlertText = driver.switchTo().alert().getText();
	   System.out.println(alertText);
	   
	   wu.alertAccept(driver);
	   //driver.switchTo().alert().accept();
	   
	   docDash.getProfileDD().click();
	   docDash.getDLogout_link().click();
	   
	   home.patientlinkClick();
	   PatientLoginPage patLogin=new PatientLoginPage(driver);
	   patLogin.getPatient_UN().sendKeys(PUN);
	   patLogin.getPatient_PWD().sendKeys(PPWD);
	   patLogin.getSubmit_Btn().click();
	   
//	   driver.findElement(By.xpath("//a[@class=\"dropdown-toggle\"]")).click();
//	   driver.findElement(By.xpath("//a[@href=\"logout.php\"]")).click();
//	   driver.findElement(By.xpath("//a[@href=\"hms/user-login.php\"]")).click();
	   
	   
//	   driver.findElement(By.name("username")).sendKeys(PUN);
//	   driver.findElement(By.name("password")).sendKeys(PPWD);
//	   driver.findElement(By.name("submit")).click();
	   
	   PatientDashboardPage patDash=new PatientDashboardPage(driver);
	   patDash.getMedicalHistory_submod().click();
	   
	  // driver.findElement(By.xpath("//span[text()=\" Medical History \"]")).click();
	   driver.findElement(By.xpath("//i[@class=\"fa fa-eye\"]")).click();
	   
	   patDash.getProfileDD().click();
	   patDash.getLogout_link().click();
	   //logout
//	   driver.findElement(By.xpath("//a[@class=\"dropdown-toggle\"]")).click();
//	   driver.findElement(By.xpath("//a[@href=\"logout.php\"]")).click();
//		    
		
	}

}
