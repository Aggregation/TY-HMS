package com.hms.hospice.sprint1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.hms.hospice.GenericUtils.DatabaseUtils;
import com.hms.hospice.GenericUtils.ExcelUtils;
import com.hms.hospice.GenericUtils.FileUtils;
import com.hms.hospice.GenericUtils.JavaUtils;
import com.hms.hospice.GenericUtils.WebdriverUtils;
import com.objectRepository.HomePage;
import com.objectRepository.PatientBookAppointmentPage;
import com.objectRepository.PatientDashboardPage;
import com.objectRepository.PatientLoginPage;

public class PatientBookAppointmentTest {
	public static void main(String[] args) throws Throwable {
		
		WebdriverUtils wu=new WebdriverUtils();
		FileUtils fu=new FileUtils();
		ExcelUtils eu=new ExcelUtils();
		JavaUtils ju=new JavaUtils();
		DatabaseUtils du=new DatabaseUtils();
		
		//FileInputStream fid=new FileInputStream(".\\src\\test\\resources\\commomDataSprint1.properties");
		//Properties pobj=new Properties();
		//pobj.load(fid);
//		
//		String BROWSER=pobj.getProperty("browser");
//		String URL=pobj.getProperty("url");
//		String PUN=pobj.getProperty("PatientName");
//		String PPWD=pobj.getProperty("PatientPassword");
//		
		
		String BR = fu.readDataFromPropertyFile("browser");
		String URL = fu.readDataFromPropertyFile("url");
		String PUN = fu.readDataFromPropertyFile("PatientName");
		String PPWD = fu.readDataFromPropertyFile("PatientPassword");
		
		WebDriver driver=new ChromeDriver();
		
		//driver.manage().window().maximize();
		wu.maximizeWindow(driver);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wu.waitForPageLoad(driver, 5);
		
		driver.get(URL);
		
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.get(URL);
		
		HomePage home=new HomePage(driver);
		home.patientlinkClick();
		
		//driver.findElement(By.xpath("//a[@href=\"hms/user-login.php\"]")).click();
		
		PatientLoginPage patlogin=new PatientLoginPage(driver);
		patlogin.getPatient_UN().sendKeys(PUN);
		patlogin.getPatient_PWD().sendKeys(PPWD);
		patlogin.getSubmit_Btn().click();
		
//		WebElement username = driver.findElement(By.name("username"));
//		username.click();
//		username.sendKeys(PUN);
//		
//		WebElement password = driver.findElement(By.name("password"));
//		password.click();
//		password.sendKeys(PPWD);
//		WebElement loginbtn = driver.findElement(By.name("submit"));
//		loginbtn.click();
		
		PatientDashboardPage patDash=new PatientDashboardPage(driver);
		patDash.getBook_appointment_link().click();
		
		//driver.findElement(By.xpath("//a[@href=\"book-appointment.php\"]/parent::p[@class=\"links cl-effect-1\"]")).click();
		
		WebElement DoctorSpec = driver.findElement(By.name("Doctorspecialization"));
		
		wu.selectByValueDD(DoctorSpec, "Homeopath");
		//Select selectDoctSpec=new Select(DoctorSpec);
		//selectDoctSpec.selectByValue("Homeopath");
		
		WebElement DoctorDD = driver.findElement(By.name("doctor"));
		
		wu.selectByVisibleTextDD(DoctorDD, "remo");
		//Select selectDoct=new Select(DoctorDD);
		//selectDoct.selectByVisibleText("remo");
		PatientBookAppointmentPage patBook=new PatientBookAppointmentPage(driver);
//		patBook.getDate_Field().click();
		
		driver.findElement(By.name("appdate")).click();
		driver.findElement(By.xpath("//td[text()=\"26\"]")).click();
		driver.findElement(By.name("apptime")).click();
		for(int i=0;i<=5;i++)
		{
			
			driver.findElement(By.xpath("//a[@data-action=\"decrementHour\"]")).click();
			driver.findElement(By.xpath("//a[@data-action=\"decrementMinute\"]")).click();
			driver.findElement(By.xpath("//a[@data-action=\"toggleMeridian\"]")).click();
		}
		
		patBook.getSubmitBtn().click();
		//driver.findElement(By.xpath("//button[@class=\"btn btn-o btn-primary\"]")).click();
		
		
		String AlertMessage = driver.switchTo().alert().getText();
		System.out.println(AlertMessage);
		driver.switchTo().alert().accept();
	}

}
