package Xpath;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test {
	
	@Test
	public void count()
	{
		String s="i love texting";
		String s1=s.replaceAll(" ", "");
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<s1.length();i++)
		{
			if(map.containsKey(s1.charAt(i)))
			{
				map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
			}
			else
			{
				map.put(s1.charAt(i), 1);
			}
		}
		for(Entry<Character, Integer> m:map.entrySet())
		{
			System.out.println(m.getKey()+" count is "+m.getValue());
		}
	}

	
	
	
	@Test
	public void test2()
	{
		int a[]= {2,4,1,9,7,3};
		
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++)
		{
			
			if(map.containsKey(a[i]))
			{
				
			}
		}
		
		
		
	}
	
	@Test
	public void test3()
	{
		int a[]= {1,1,0,0,0,1,1,0};
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==1)
			{
				al.add(a[i]);
				
			}
		}
		for(int j=0;j<a.length;j++)
		{
			if(a[j]==0)
			{
			al.add(a[j]);
				
			}
			
		}
		
		System.out.println(al);
		
		
		
	}
	
	
	@Test
	public void test4()
	{
		String s="test123asdf456";                        //579
		String s1=s.replaceAll("[a-zA-Z]", " ");
		String s2[]=s1.split(" ");
		int sum=0;
		for(int i=0;i<s2.length;i++)
		{
			//System.out.println(s2[i]);
			String n=s2[i];
			if(n!="")
			{
				int j=Integer.parseInt(n);
				sum=sum+j;
			}
			
			System.out.println(n);
			
			
		}
	}
	

	
//	@DataProvider(name = "data")
//	public Object[][] data()
//	{
//		
//	 Object	object=new Object[row][col]; 
//	 return object;
//	}
//	
//	@bs
//	@bc
//	@bm
//	
//	@test
//	
//	@am
//	@ac
//	@as
//	
//	
//	
//	given()
//	.body("fgh")
//	.contentType(contentype.json)
//	
//	.when()
//	.post("url")
//	
//	.then()
//	.asserThat.
//	.statuscode(code).
//	.log().all();
//	
	
	@Test
	public void waitimp()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(1));
		List<WebElement> ele = driver.findElements(By.xpath("//img[@class=\"_2puWtW _3a3qyb\"]"));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
		driver.quit();
		driver.close();
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
	}
	
	@Test
	public void revSame()
	{
		String s="i love testing";
		String s1=s.replaceAll(" ", "");
		int count=s1.length()-1;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=' ')
			{
				System.out.print(s1.charAt(count--));
			}
			else
			{
				System.out.print(s.charAt(i));
			}
		}
	}
	
	@Test
	public void anagram()
	{
		String s="mama";
		String s1="amma";
		boolean flag=false;
		if(s.length()==s1.length())
		{
			char c1[]=s.toCharArray();
			char c2[]=s.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			if(Arrays.equals(c1, c2))
			{
				flag=true;
			}
			if(flag==true)
			System.out.println("Both are anagram");
		}
		else if(flag==false)
		{
			System.out.println("not a anagram");
		}
	}
	
	
	@Test
	public void sum()
	{
		int a[]= {2,4,1,9,7,3};
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]+a[j]==10)
				{
					if(map.containsKey(a[i])!=true && map.containsValue(a[j])!=true)
					{
						map.put(a[i], a[j]);
						System.out.println(i+" "+j);
						
					}
				}
			}
		}
		System.out.println(map);
	}
	
	@Test
	public void space()
	{
		String s="Jennifer";
		for(int i=0;i<s.length();i++)
		{
			System.out.print(s.charAt(i));
			for(int j=0;j<=i;j++)
			{
				System.out.print(" ");
			}
		}
		
		System.out.println("done");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
