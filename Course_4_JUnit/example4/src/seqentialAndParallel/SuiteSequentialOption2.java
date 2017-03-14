package seqentialAndParallel;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class SuiteSequentialOption2 {

	@Test
	public void runClassesAndMethodsSequential() {
		Class<?>[] theClasees = {FirstClass.class, SecondClass.class};
		
		JUnitCore.runClasses(theClasees);
		Result theResult = JUnitCore.runClasses(theClasees);
		
		System.out.println ("The final Result was (false=Failed, true=Passed) : "+ theResult.wasSuccessful());
		System.out.println ("The number of Runs Tests was: " + theResult.getRunCount());
		System.out.println ("The number of failure was: " + theResult.getFailureCount());
		System.out.println ("The failure messages were: " + theResult.getFailures());
	}

}