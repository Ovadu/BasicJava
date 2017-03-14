package homework4;

import org.junit.*;

/**
 * Created by ovidiu.luchian on 07-Mar-17.
 */
public class Total{
    static LoanCalculator loan;
    static double monthlyRate;

    @BeforeClass
    public static void createObject(){
        double[] arg = {90000, 9, 5};
        System.out.println(String.format("Attempting to create loan with Amount: %s, Term: %s, Interest %s\n", (int) arg[0], (int) arg[1], arg[2]));
        loan = new LoanCalculator((int) arg[0], (int) arg[1], arg[2]);
        monthlyRate = loan.monthlyRate();
        System.out.println("The loan has been created successfully.");
        System.out.println("-------------------------------------------------------------------");

    }

    @AfterClass
    public static void destroy(){
        loan = null;
        System.out.println("The loan object has been destroyed.");
    }

    @Before
    public void totalNotNull(){
        Assert.assertNotNull(loan.total());
    }

    @After
    public void separator(){
        System.out.println("-------------------------------------------------------------------");
    }

    @Test
    public void totalTrue(){
        System.out.println("Verifying if the total amount is larger than the loan amount due to the applied interest.");
        Assert.assertTrue(loan.total() > loan.getLoanAmount());
    }


    @Test
    public void totalEquals(){
        System.out.println("Verifying if the total amount is calculated as expected.");
        Assert.assertEquals(111945, loan.total(), 1); //delta is 1 in order to be able to verify with the online calculator that is less precise
    }

    @Test
    public void totalFalse(){
        System.out.println("Verifying that the total is not calculated with the interest applied to the entire period.");
        Assert.assertFalse(loan.total() == loan.getLoanAmount() * loan.getInterest() / 100 + loan.getLoanAmount());
    }

}