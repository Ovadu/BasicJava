package seqentialAndParallel;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class SuiteParallelClassesAndMethods {

	//if we want to run both CLASSES, TestExecutionOrder1.class and TestExecutionOrder2.class in PARALLEL
	//and all of their METHODS in PARALLEL
	
	//all test methods will run in separate threads
	@Test
	public void runClassesAndMethodsInParallel(){
	Class<?>[] theClasses = {FirstClass.class, SecondClass.class};
	
	Result theResult = JUnitCore.runClasses(new ParallelComputer(true, true), theClasses);

	System.out.println ("The final Result was (false=Failed, true=Passed) : "+ theResult.wasSuccessful());
	System.out.println ("The number of Runs Tests was: " + theResult.getRunCount());
	System.out.println ("The number of failure was: " + theResult.getFailureCount());
	System.out.println ("The failure messages were: " + theResult.getFailures());
	
	}

}
