package seqentialAndParallel;


import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class SuiteParallelMethods {

	//if we want to run the METHODS from TestExecutionOrder1.class and TestExecutionOrder2.class in PARALLEL
	//but the two CLASSES, TestExecutionOrder1 and TestExecutionOrder2, SEQUENTIAL:
	
	////all test methods will run in separate threads
	@Test
	public void runMethodsInParallel() {
		Class<?>[] theClasses = {FirstClass.class, SecondClass.class};
		
		Result theResult = JUnitCore.runClasses(ParallelComputer.methods(), theClasses);
		
		System.out.println ("The final Result was (false=Failed, true=Passed) : "+ theResult.wasSuccessful());
		System.out.println ("The number of Runs Tests was: " + theResult.getRunCount());
		System.out.println ("The number of failure was: " + theResult.getFailureCount());
		System.out.println ("The failure messages were: " + theResult.getFailures());
		
	}

}
