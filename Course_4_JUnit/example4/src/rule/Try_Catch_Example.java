package rule;

import org.junit.Assert;

import org.junit.Test;

public class Try_Catch_Example {
	
	int firstNo = 5;
	int secondNo = 9;

	@Test
	public void testingSomething() { //every assert is executed, BUT the test cases appears as passed 
		                             //even if one or more of the Asserts have failed
		
		try {
			Assert.assertEquals(firstNo, secondNo);
		} catch (Throwable t) {}
		
		try {
			Assert.assertTrue(firstNo>secondNo);
		} catch (Throwable t) {}
		
		try {
			Assert.assertTrue(firstNo<secondNo);
		} catch (Throwable t) {}
	}

}
