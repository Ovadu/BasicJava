package homework4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ovidiu.luchian on 07-Mar-17.
 */
public class MonthlyRate{
    LoanCalculator loan;

    @After
    public void divideAndDestroy(){
        loan = null;
        System.out.println("The loan object has been destroyed.");
        System.out.println("-------------------------------------------------------------------");
    }


    @Test
    public void monthlyRateNotNull(){
        double[] arg = {115683, 9, 6};
        System.out.println(String.format("Attempting to create loan with Amount: %s, Term: %s, Interest %s\n", (int) arg[0], (int) arg[1], arg[2]));
        try {
            loan = new LoanCalculator((int) arg[0], (int) arg[1], arg[2]);
            System.out.println("The loan has been created successfully.");
            System.out.println(String.format("Amount: %s, Term in months: %s, Interest: %s", loan.getLoanAmount(), loan.getLoanTerm(), loan.getInterest()));
            System.out.println(String.format("The monthly rate is: %s", loan.monthlyRate()));
        } catch (Throwable t) {
            System.out.println(String.format("The loan object was not created because of: %s", t));
//            throw t; //The exception is thrown again in order to be caught by the test.
        }
        Assert.assertNotNull(loan.monthlyRate());

    }

    @Test
    public void monthlyRateEquals(){
        double[] arg = {30000, 3, 9.8};
        double expected = 965.20;

        System.out.println(String.format("Attempting to create loan with Amount: %s, Term: %s, Interest %s\n", (int) arg[0], (int) arg[1], arg[2]));
        try {
            loan = new LoanCalculator((int) arg[0], (int) arg[1], arg[2]);
            System.out.println("The loan has been created successfully.");
            System.out.println(String.format("Amount: %s, Term in months: %s, Interest: %s", loan.getLoanAmount(), loan.getLoanTerm(), loan.getInterest()));
            System.out.println(String.format("The monthly rate is: %s", loan.monthlyRate()));
        } catch (Throwable t) {
            System.out.println(String.format("The loan object was not created because of: %s", t));
//            throw t; //The exception is thrown again in order to be caught by the test.
        }

        Assert.assertEquals(expected, loan.monthlyRate(), 1); //delta is 1 in order to be able to verify with the online calculator that is less precise

    }


    //Verify if the interest was applied to the monthly payment
    @Test
    public void monthlyRateTrue(){
        double[] arg = {30000, 6, 12.5};
        double rateNoInterest = arg[0] / arg[1] / 12;
        System.out.println(String.format("Attempting to create loan with Amount: %s, Term: %s, Interest %s\n", (int) arg[0], (int) arg[1], arg[2]));
        try {
            loan = new LoanCalculator((int) arg[0], (int) arg[1], arg[2]);
            System.out.println("The loan has been created successfully.");
            System.out.println(String.format("Amount: %s, Term in months: %s, Interest: %s", loan.getLoanAmount(), loan.getLoanTerm(), loan.getInterest()));
            System.out.println(String.format("The monthly rate is: %s. Without interest would be %s", loan.monthlyRate(), rateNoInterest));
        } catch (Throwable t) {
            System.out.println(String.format("The loan object was not created because of: %s", t));
//            throw t; //The exception is thrown again in order to be caught by the test.
        }

        Assert.assertTrue(loan.monthlyRate() > rateNoInterest);

    }

}
