package homework4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by ovidiu.luchian on 02-Mar-17.
 * <p>
 * Test constructor method:1
 * - Test if an object based on LoanCalculator can be created using valid arguments
 * - Test if the the object based on LoanCalculator is created when using invalid arguments
 * - Test if the correct exception is thrown when invalid arguments are entered
 */

public class InitLoanCalculator{
    private LoanCalculator loan;

    @After
    public void divideAndDestroy(){
        loan = null;
        System.out.println("The loan object has been destroyed.");
        System.out.println("-------------------------------------------------------------------");
    }

    //Test if the a valid object can be created
    @Test
    public void constructorTestCreate(){
        //Arguments passed to the constructor method.
        double[] arg = {3500, 2, 8};
        System.out.println(String.format("Attempting to create loan with Amount: %s, Term: %s, Interest %s\n", (int) arg[0], (int) arg[1], arg[2]));
        try {
            loan = new LoanCalculator((int) arg[0], (int) arg[1], arg[2]);
            System.out.println(String.format("Amount: %s, Term in months: %s, Interest: %s", loan.getLoanAmount(), loan.getLoanTerm(), loan.getInterest()));
        } catch (Throwable t) {
            System.out.println(String.format("The loan object was not created because of: %s", t));
            //throw t; //The exception is thrown again in order to be caught by the test.
        }

        Assert.assertNotNull(loan);//Test if the object was indeed created
    }

    //Verify that the object is not created with invalid arguments
    @Test
    public void constructorTestNull(){
        //Arguments passed to the constructor method.
        double[] arg = {-4500, -2, 110};
        System.out.println(String.format("Attempting to create loan with Amount: %s, Term: %s, Interest %s\n", (int) arg[0], (int) arg[1], arg[2]));
        try {
            loan = new LoanCalculator((int) arg[0], (int) arg[1], arg[2]);
            System.out.println(String.format("Amount: %s, Term in months: %s, Interest: %s", loan.getLoanAmount(), loan.getLoanTerm(), loan.getInterest()));
        } catch (Throwable t) {
            System.out.println(String.format("The loan object was not created because of: %s", t));
            //throw t; //The exception is thrown again in order to be caught by the test.
        }

        Assert.assertNull(loan);

    }

    //Verify if invalid arguments passed to the constructor throws the correct exception.
    @Test(expected = IllegalArgumentException.class)
    public void constructorTestException(){
        //Arguments passed to the constructor method.
        double[] arg = {0, 0, 102};
        System.out.println(String.format("Attempting to create loan with Amount: %s, Term: %s, Interest %s\n", (int) arg[0], (int) arg[1], arg[2]));
        try {
            loan = new LoanCalculator((int) arg[0], (int) arg[1], arg[2]);
            System.out.println(String.format("Amount: %s, Term in months: %s, Interest: %s", loan.getLoanAmount(), loan.getLoanTerm(), loan.getInterest()));
        } catch (Throwable t) {
            System.out.println(String.format("The loan object was not created because of: %s", t));
            throw t; //The exception is thrown again in order to be caught by the test.
        }
    }

}