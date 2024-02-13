package com.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_ManageDoctorPage {
	
	@FindBy(xpath="//tr//td[3]/following-sibling::td/div/a[@href=\"edit-doctor.php?id=3\"]")
	private WebElement Editicon;
	
	@FindBy(xpath = "//a[@tooltip=\"Remove\"]")
	//@FindAll({@FindBy(xpath = "//a[@tooltip=\"Remove\"]"),@FindBy(xpath = "//a[@class=\"btn btn-transparent btn-xs tooltips\"]")})
	private List<WebElement> deleteDoc;
	

	public List<WebElement> getDeleteDoc() {
		return deleteDoc;
	}

	public Admin_ManageDoctorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEditicon() {
		return Editicon;
	}
	
	public void deletedoc(WebDriver driver) throws InterruptedException
	{
		
	
	   for(WebElement ele: deleteDoc)
	   {
		   String wid = driver.getWindowHandle();
		   ele.click();
		   Thread.sleep(1000);
		   driver.switchTo().alert().accept();
		   driver.switchTo().window(wid);
		   System.out.println(ele+"------- deleted");
	   }
	}
	
}
