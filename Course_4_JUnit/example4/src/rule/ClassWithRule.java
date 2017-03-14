package rule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ClassWithRule {
	
	int firstNo = 5;
	int secondNo = 9;
	
	@Rule
	public ErrorCollector theErrors = new ErrorCollector(); //http://junit.org/junit4/javadoc/latest/org/junit/rules/ErrorCollector.html

	@Test
	public void testingSomething() {
		try{
			Assert.assertEquals(firstNo, secondNo); //fail - will return an error
		} catch (Throwable t){ //The Throwable class is the superclass of all errors and exceptions in the Java language.
								//Throwable is super class of Exception as well as Error.
			theErrors.addError(t); //use this method to log the errors
		}
		
		try{
			Assert.assertTrue(firstNo>secondNo); //fail - will return an error
		} catch (Throwable t){
			theErrors.addError(t);
		}
		
		try{
			Assert.assertTrue(firstNo<secondNo); //pass
		} catch (Throwable t){
			theErrors.addError(t); 
		}
		
	}

}
