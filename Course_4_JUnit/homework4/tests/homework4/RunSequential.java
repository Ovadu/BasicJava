package homework4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by ovidiu.luchian on 08-Mar-17.
 */

@RunWith(Suite.class)
@SuiteClasses({
        InitLoanCalculator.class,
        GetInterest.class,
        GetLoanAmount.class,
        GetLoanTerm.class,
        MonthlyRate.class,
        Total.class,
        LoanRule.class,
        LoanParametrized.class
})

public class RunSequential{
}
