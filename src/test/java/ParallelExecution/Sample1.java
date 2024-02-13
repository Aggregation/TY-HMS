package ParallelExecution;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample1 {
	
	

	
	@Test
	public void t1()
	{
		System.out.println("Execute app 1");
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	public void a1()
	{
		System.out.println("axecute app 1");
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	public void cx1()
	{
		System.out.println("cxxcute app 1");
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	public void ca1()
	{
		System.out.println("caecute app 1");
		System.out.println(Thread.currentThread().getId());
	}


}
