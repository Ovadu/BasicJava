package order;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrderOfExecution {
	
	@BeforeClass //will execute this method once, before the start of all tests
	public static void beforeAll(){
		System.out.println ("BeforeAll");
	}
	
	@Before //will execute this method before each test
	public void beforeTest(){
		System.out.println("BEFORE");
	}
	
	@Test //identifies that this is a test method
	public void test1 (){
		System.out.println ("First test");
	}
	
	@Test
	public void test2() {
		System.out.println ("Second test");
	}
	
	@After //will execute this method after each test
	public void afterTest(){
		System.out.println("AFTER");
	}
	
	@AfterClass //will execute this method once, after all tests have finished
	public static void afterAll(){
		System.out.println ("AfterAll");
	}

}
