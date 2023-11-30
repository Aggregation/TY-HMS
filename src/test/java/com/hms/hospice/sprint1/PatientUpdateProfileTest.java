package com.hms.hospice.sprint1;

import java.io.FileInputStream;
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

import com.hms.hospice.GenericUtils.BaseClass;
import com.hms.hospice.GenericUtils.DatabaseUtils;
import com.hms.hospice.GenericUtils.ExcelUtils;
import com.hms.hospice.GenericUtils.FileUtils;
import com.hms.hospice.GenericUtils.IpathConstants;
import com.hms.hospice.GenericUtils.JavaUtils;
import com.hms.hospice.GenericUtils.WebdriverUtils;
import com.objectRepository.HomePage;
import com.objectRepository.PatientDashboardPage;
import com.objectRepository.PatientEditProfilePage;
import com.objectRepository.PatientLoginPage;

public class PatientUpdateProfileTest {
	public static void main(String[] args) throws Throwable {
		

		WebdriverUtils wu=new WebdriverUtils();
		FileUtils fu=new FileUtils();
		ExcelUtils eu=new ExcelUtils();
		JavaUtils ju=new JavaUtils();
		DatabaseUtils du=new DatabaseUtils();
		
		fu.readDataFromPropertyFile(IpathConstants.FILEPATH);
		String BROWSER = fu.readDataFromPropertyFile("browser");
		String URL = fu.readDataFromPropertyFile("url");
		String PUN = fu.readDataFromPropertyFile("PatientName");
		String PPWD = fu.readDataFromPropertyFile("PatientPassword");

		
	
		
		
		
		
		
//		
//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commomDataSprint1.properties");
//		Properties pobj=new Properties();
//		pobj.load(fis);
//		
//	   String BROWSER = pobj.getProperty("browser");
//	   String URL=pobj.getProperty("url");
//	   String PUN=pobj.getProperty("PatientName");
//	   String PPWD=pobj.getProperty("PatientPassword");
	   
	   WebDriver driver=new ChromeDriver();
	   wu.maximizeWindow(driver);
//	   driver.manage().window().maximize();
	   driver.get(URL);
	  wu.waitForPageLoad(driver, 5);
	  // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  HomePage home=new HomePage(driver);
	  home.patientlinkClick();
	  
	  // driver.findElement(By.xpath("//a[@href=\"hms/user-login.php\"]")).click();
	   
	  PatientLoginPage patlogin=new PatientLoginPage(driver);
	  patlogin.getPatient_UN().sendKeys(PUN);
	  patlogin.getPatient_PWD().sendKeys(PPWD);
	  patlogin.getSubmit_Btn().click();
//		WebElement username = driver.findElement(By.name("username"));
//		username.click();
//		username.sendKeys(PUN);
//		WebElement passTF = driver.findElement(By.name("password"));
//		passTF.click();
//		passTF.sendKeys(PPWD);
//		WebElement loginbtn = driver.findElement(By.name("submit"));
//		loginbtn.click();
	  
		PatientDashboardPage patDash=new PatientDashboardPage(driver);
		patDash.getPatinet_UpdateProfile_link().click();
		
		//driver.findElement(By.xpath("//a[contains(text(),\"Update Profile\")]")).click();
		
		eu.readMultipleData("PatientUpdateHistory", driver);
//		FileInputStream fetch=new FileInputStream(".\\src\\test\\resources\\TestDataHospice.xlsxx");
//		Workbook wb = WorkbookFactory.create(fetch);
//		Sheet sh = wb.getSheet("PatientUpdateHistory");
//		int count = sh.getLastRowNum();
//		
//		HashMap<String, String> map=new HashMap<String, String>();
//		
//		for(int i=0;i<=count;i++)
//		{
//			String key = sh.getRow(i).getCell(0).getStringCellValue();
//			String value=sh.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//		}
//		
//		for(Entry<String, String> updateData:map.entrySet())
//		{
//			 WebElement element = driver.findElement(By.name(updateData.getKey()));
//			 element.clear();
//			 element.sendKeys(updateData.getValue());
//		}
		
	
		PatientEditProfilePage patEdProPage=new PatientEditProfilePage(driver);
		patEdProPage.getSubmitBtn().click();
		//driver.findElement(By.name("submit")).click();
	
		 
		
		WebElement message = patEdProPage.getConformMessage();
		String UpdateMessage = message.getText();
		
//		WebElement message = driver.findElement(By.xpath("//h5[@style=\"color: green; font-size:18px; \"]"));
//		String UpdateMessage = message.getText();
		
		System.out.println(UpdateMessage);
		
		patDash.getProfileDD().click();
		patDash.getLogout_link().click();
		
//		driver.findElement(By.xpath("//a[@class=\"dropdown-toggle\"]")).click();
//		driver.findElement(By.xpath("//a[@href=\"logout.php\"]")).click();
		
		home.patientlinkClick();
		
		// driver.findElement(By.xpath("//a[@href=\"hms/user-login.php\"]")).click();
		 
		  patlogin.getPatient_UN().sendKeys(PUN);
		  patlogin.getPatient_PWD().sendKeys(PPWD);
		  patlogin.getSubmit_Btn().click();
		
//			WebElement usernameagain = driver.findElement(By.name("username"));
//			usernameagain.click();
//			usernameagain.sendKeys(PUN);
//			WebElement passTFAgain = driver.findElement(By.name("password"));
//			passTFAgain.click();
//			passTFAgain.sendKeys(PPWD);
//			WebElement loginbtnAgain = driver.findElement(By.name("submit"));
//			loginbtnAgain.click();
		  patDash.getPatinet_UpdateProfile_link().click();
			//driver.findElement(By.xpath("//a[contains(text(),\"Update Profile\")]")).click();
		
		
		
		
		
	
	
	}

}
