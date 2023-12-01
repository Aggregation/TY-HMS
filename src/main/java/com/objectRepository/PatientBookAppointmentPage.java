package com.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientBookAppointmentPage {
	
	@FindBy(xpath = "//select[@name=\"Doctorspecialization\"]")
	private WebElement DoctorSpecDD;
	
	@FindBy(xpath = "//select[@name=\"doctor\"]")
	private WebElement DoctornameTF;
	
	@FindBy(xpath = "//tbody/descendant::td[@class=\"day\" and text()=\"25\"]")
	private WebElement Date_Field;
	
	@FindBy(name = "appdate")
	private WebElement dateTf;
	
	@FindBy(name = "apptime")
	private WebElement TimeField;
	
	@FindBy(xpath = "//a[@data-action=\"decrementHour\"]")
	private WebElement DecrementHour;
	
	@FindBy(xpath = "//a[@data-action=\"decrementMinute\"]")
	private WebElement DecrementMinute;
	
	@FindBy(xpath = "//a[@data-action=\"toggleMeridian\"]")
	private WebElement IncrementSession;
	
	@FindBy(name = "submit")
	private WebElement SubmitBtn;
	
	
	
//constructor
	public PatientBookAppointmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getDoctorSpecDD() {
		return DoctorSpecDD;
	}

	public WebElement getDoctornameTF() {
		return DoctornameTF;
	}

	public WebElement getDate_Field() {
		return Date_Field;
	}

	public WebElement getDateTf() {
		return dateTf;
	}

	
	public WebElement getTimeField() {
		return TimeField;
	}
	
	

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	public WebElement getDecrementHour() {
		return DecrementHour;
	}

	public WebElement getDecrementMinute() {
		return DecrementMinute;
	}

	public WebElement getIncrementSession() {
		return IncrementSession;
	}
	
	//bussiness logic
	
	public void selectDate()
	{
		dateTf.click();
		Date_Field.click();
	}
	
	public void selectTime()
	{
		TimeField.click();
		for(int i=0;i<=5;i++)
		{
			DecrementHour.click();
			DecrementMinute.click();
			IncrementSession.click();
			
		}
		
	}



}
