package Xpath;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Bigbasket {
	
	@Test
	public void veg() throws EncryptedDocumentException, IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		WebElement catagory = driver.findElement(By.xpath("//div[@class=\"Header___StyledCategoryMenu2-sc-19kl9m3-13 ibVaum\"]"));
	    catagory.click();
	    List<WebElement> veg= driver.findElements(By.xpath("//a[text()=\"Fresh Vegetables\"]/ancestor::nav[@class=\"jsx-1259984711 flex text-medium\"]//ul[@class=\"jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs\"]/li[@class=\"jsx-1259984711\"]"));
	    int rowsize = veg.size();
	    
	   
	   
	    for(int i=0;i<veg.size();i++)
	    {
	    	 String s=veg.get(i).getText();
	    	 System.out.println(s);
	    	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Veg.xlsx");
	 	     Workbook wb = WorkbookFactory.create(fis);
	 	     Sheet sh = wb.getSheet("veg");
	 	     sh.createRow(i).createCell(0).setCellValue(s);
	 	     FileOutputStream fout=new FileOutputStream(".\\src\\test\\resources\\Veg.xlsx");
	    	 wb.write(fout);
	    	 wb.close();
	    }
	    
	    
	     
	}
	
	@Test
	public void mouse()
	{
		
	}

}
