package ParallelExecution;

import org.testng.annotations.Test;

public class TestCase extends TestBase {
	
	@Test(priority = 1)
	public void test1()
	{
		System.out.println("1 test method "+Thread.currentThread().getId());
	}
	
	@Test(priority = 3)
	public void test2()
	{
		System.out.println("2 test method "+Thread.currentThread().getId());
	}
	
	@Test(priority = 2)
	public void test3()
	{
		System.out.println("3 test method "+Thread.currentThread().getId());
	}

}
