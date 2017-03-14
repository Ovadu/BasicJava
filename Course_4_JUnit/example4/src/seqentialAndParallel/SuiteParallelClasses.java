package seqentialAndParallel;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class SuiteParallelClasses {
		
	//if we want to run the CLASSES from TestExecutionOrder1.class and TestExecutionOrder2.class in PARALLEL
	//but the two METHODS from each class SEQUENTIAL:
	
	
	//each class runs in its own thread and the methods in the same class runs in the same thread
	@Test
	public void runClassesInParallel() {
		Class<?>[] theClasses = {FirstClass.class, SecondClass.class};

		Result theResult = JUnitCore.runClasses(ParallelComputer.classes(), theClasses);

		System.out.println ("The final Result was (false=Failed), true=Passed) : "+ theResult.wasSuccessful());
		System.out.println ("The number of Runs Tests was: " + theResult.getRunCount());
		System.out.println ("The number of failure was: " + theResult.getFailureCount());
		System.out.println ("The failure messages were: " + theResult.getFailures());

	}



}
