package ParallelExecution;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample3 {
	@BeforeMethod
	public void bm()
	{
		System.out.println("login the app 3");
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	public void t1()
	{
		System.out.println("Execute app 3");
		System.out.println(Thread.currentThread().getId());
	}
	
	@AfterMethod
	public void am()
	{
		System.out.println("Logout the app 3");
		System.out.println(Thread.currentThread().getId());
	}

}
