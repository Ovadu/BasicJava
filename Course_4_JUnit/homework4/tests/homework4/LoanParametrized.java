package homework4;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by ovidiu.luchian on 07-Mar-17.
 */
@RunWith(Parameterized.class)
public class LoanParametrized{
    private LoanCalculator loan;
    private double x;
    private double y;
    private double z;
    private double rate;
    private double total;


    public LoanParametrized(double x, double y, double z, double rate, double total){
        this.x = x;
        this.y = y;
        this.z = z;
        this.rate = rate;
        this.total = total;
    }

    @Parameterized.Parameters
    public static Collection<Double[]> ids(){
        return Arrays.asList(new Double[][]{
                {16000d, 6d, 3.6, 247.4, 17814.0},
                {4500d, 2d, 8.0, 1564.3, 4884.5},
                {6300d, 3d, 7.1, 194.8, 3d},
                {99500d, 5d, 4.5, 15864.3, 3d},
                {26000d, 3d, 10.62, 15864.3, 3d},
                {38000d, 4d, 10.2, 15864.3, 3d},
                {43000d, 5d, 10.2, 15864.3, 3d},
                {38000d, 3d,6.2, 15864.3, 3d},
                {6300d, 3d, 7.1, 194.8, 3d}
        });
    }
    @Before
    public void createLoan(){
        loan = new LoanCalculator((int) x, (int) y, z);
    }

    @After
    public void destroyLoan(){
        loan = null;
    }

    @Test
    public void monthlyRateValues(){
        Assert.assertEquals(rate, loan.monthlyRate(), 1);
    }

    @Test
    public void totalValues(){
        Assert.assertEquals(total, loan.total(), 1);
    }

    @Test
    public void consistencyTotal(){
        Assert.assertEquals(total, loan.monthlyRate()*loan.getLoanTerm()*12, 1);
    }

}