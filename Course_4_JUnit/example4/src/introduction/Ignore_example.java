package introduction;

import org.junit.Test;
import org.junit.Ignore;

public class Ignore_example {

	@Test
	public void test1() {
		System.out.println ("First test");
	}
	
	@Ignore @Test
	public void test2 (){
		System.out.println ("Second test");
	}
	
	@Test
	public void test3(){
		System.out.println ("Third test");
	}
	
	

}
