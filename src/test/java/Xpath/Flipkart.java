package Xpath;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Flipkart {
	
	@Test
	public void total()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/search?q=apple+iphone+14+&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&page=1");
		//List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]"));
		int sum=0;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		int exp=168;
		//System.out.println(elements.size());
		try {
		WebElement nextEle = driver.findElement(By.xpath("//span[text()=\"Next\"]"));
		
		List<WebElement> number = driver.findElements(By.xpath("//nav[@class=\"yFHi8N\"]/child::a[contains(@class,'ge-49M')]"));
		
		for (WebElement webElement : number) 
		{
		      String textNum = webElement.getText();
		      int n= Integer.parseInt(textNum);
		
		
		//WebElement text = driver.findElement(By.xpath("//a[text()=\"7\"]"));
		//String te = text.getText();
		//int n = Integer.parseInt(te);
		for(int i=0;i<n;i++)
		{
		
			List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]"));
			int total=elements.size();
			sum=sum+total;
			nextEle.click();
			
		
			
		}
		}
		}
		catch (StaleElementReferenceException e) {
			
			System.out.println(sum);
		}
		
		System.out.println(sum);
		if(sum==exp)
		{
			System.out.println("all the products are  dispalyed");
		}
		else
		{
			System.out.println("all the products are not dispalyed");
		}
	}
	
	@Test
	public void move()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement fasion = driver.findElement(By.xpath("//div[@class=\"YBLJE4\" and contains(.,\"Fashion\")]"));
	    Actions action=new Actions(driver);
	    action.moveToElement(fasion).click().perform();
	}
	
	
	
//	public static void main(String[] args) {
//		
//	
//
//	String s="naveenkumar";
//	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//	for(int i=0;i<s.length();i++)
//	{
//		if(map.containsKey(s.charAt(i)))
//		{
//			map.put(s.charAt(i), map.get(s.charAt(i))+1);
//		}
//		else
//		{
//			map.put(s.charAt(i), 1);
//		}
//	}
//	for(Entry<Character, Integer> m :map.entrySet())
//	{
//		if(m.getValue()>1)
//		{
//			System.out.println(m.getKey()+" "+m.getValue()); 
//			
//		}
//	}
//
//	}
//	
	

}
