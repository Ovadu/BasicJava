package homework4;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Created by ovidiu.luchian on 08-Mar-17.
 */
public class RunParallelAll{
    @Test
    public void runParallelAll(){
        Class<?>[] theClasses = {InitLoanCalculator.class, GetInterest.class, GetLoanAmount.class, GetLoanTerm.class,
                MonthlyRate.class, Total.class, LoanRule.class, LoanParametrized.class};

        Result theResult = JUnitCore.runClasses(new ParallelComputer(true, true), theClasses);

        System.out.printf("The final result was (false=Failed, true=Passed): %s\n", theResult.wasSuccessful());
        System.out.printf("Run time: %s milliseconds\n", theResult.getRunTime());
        System.out.printf("Number of tests: %s\n", theResult.getRunCount());
        System.out.printf("Number of failures: %s\n", theResult.getFailureCount());
        System.out.printf("Fail messages: %s\n", theResult.getFailures());
    }
}
