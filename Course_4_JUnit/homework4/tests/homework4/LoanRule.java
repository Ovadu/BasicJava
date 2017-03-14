package homework4;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * Created by ovidiu.luchian on 07-Mar-17.
 */
public class LoanRule{
    private LoanCalculator loan1;
    private LoanCalculator loan2;
    private LoanCalculator loan3;

    @org.junit.Rule
    public ErrorCollector theErrors = new ErrorCollector();

    @After
    public void divideAndDestroy(){
        loan1 = null;
        loan2 = null;
        loan3 = null;
    }

    //Test if the a valid object can be created
    @Test
    public void constructorTestCreate(){
        //Arguments passed to the constructor method.
        loan1 = new LoanCalculator(3500, 2, 8.3);
        loan2 = new LoanCalculator(4500, 2, 11);
        loan3 = new LoanCalculator(6000, 3, 10);

        try {
            Assert.assertTrue(loan1.getInterest()<100);//Test if the object was indeed created
        } catch (Throwable t) {
            theErrors.addError(t);
        }

        try {
            Assert.assertEquals(4500, loan2.getLoanAmount());
        } catch (Throwable t) {
            theErrors.addError(t);
        }

        try {
            Assert.assertFalse(loan3.getLoanAmount()<0);
        } catch (Throwable t){
            theErrors.addError(t);
        }

    }


}