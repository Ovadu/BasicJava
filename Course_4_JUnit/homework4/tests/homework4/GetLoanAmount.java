package homework4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by ovidiu.luchian on 06-Mar-17.
 */
public class GetLoanAmount{
    private LoanCalculator loan;

    @After
    public void divideAndDestroy(){
        loan = null;
        System.out.println("The loan object has been destroyed.");
        System.out.println("-------------------------------------------------------------------");
    }


    @Test
    public void getLoanAmountTestNotNull(){
        double[] arg = {28000, 6, 10}; //Arguments passed to the constructor method.
        System.out.println(String.format("Attempting to create loan with Amount: %s, Term: %s, Interest %s\n", (int) arg[0], (int) arg[1], arg[2]));
        try {
            loan = new LoanCalculator((int) arg[0], (int) arg[1], arg[2]);
        } catch (Throwable t) {
            System.out.println(String.format("The loan object was not created because of: %s", t));
            //throw t; //The exception is thrown again in order to be caught by the test.
        }

        Assert.assertNotNull(loan.getLoanAmount());
    }

    @Test
    public void getLoanAmountTestEquals(){
        double[] arg = {39000, 7, 12}; //Arguments passed to the constructor method.
        System.out.println(String.format("Attempting to create loan with Amount: %s, Term: %s, Interest %s\n", (int) arg[0], (int) arg[1], arg[2]));
        try {
            loan = new LoanCalculator((int) arg[0], (int) arg[1], arg[2]);
        } catch (Throwable t) {
            System.out.println(String.format("The loan object was not created because of: %s", t));
            //throw t; //The exception is thrown again in order to be caught by the test.
        }

        Assert.assertEquals((int) arg[0], loan.getLoanAmount(), 0);
    }

    //Verify if invalid arguments passed to the constructor throws the correct exception.
    @Test(expected = NullPointerException.class)
    public void getLoanAmountTestException(){
        //Arguments passed to the constructor method.
        double[] arg = {0, 3, 8};
        System.out.println(String.format("Attempting to create loan with Amount: %s, Term: %s, Interest %s\n", (int) arg[0], (int) arg[1], arg[2]));
        try {
            loan = new LoanCalculator((int) arg[0], (int) arg[1], arg[2]);
            System.out.println(String.format("Amount: %s, Term in months: %s, Interest: %s", loan.getLoanAmount(), loan.getLoanTerm(), loan.getInterest()));
        } catch (Throwable t) {
            System.out.println(String.format("The loan object was not created because of: %s", t));
//            throw t; //The exception is thrown again in order to be caught by the test.
        }

        try {
            Assert.assertTrue(loan.getLoanAmount() == (int) arg[0]);
        } catch (Throwable t) {
            System.out.println(String.format("The loan amount cannot be returned because of: %s", t));
            throw t; //The exception is thrown again in order to be caught by the test.
        }
    }

}