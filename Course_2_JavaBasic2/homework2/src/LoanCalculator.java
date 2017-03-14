/**
 * Created by ovidiu.luchian on 15-Feb-17.
 */
public class LoanCalculator{

    // Define LoanCalculator variables.
    private int loanAmount;
    private int loanTerm;
    private double interest;

    public LoanCalculator(int loanAmount, int loanTerm, double interest){

        // Crete initial values for the LoanCalculator object
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.interest = interest;

        // Throw IllegalArgumentException if loanAmount OR loanTerm <= 0 OR interest > 100
        if (loanAmount <= 0 || loanTerm <= 0 || interest > 100){
            throw new IllegalArgumentException();
        }

    }

    public int getLoanAmount(){
        return loanAmount;
    }

    public int getLoanTerm(){
        return loanTerm;
    }

    public double getInterest(){
        return interest;
    }

    public double monthlyRate(){
        double douAnualInterest = interest / (12 * 100);

        double douPayAm = (loanAmount * douAnualInterest * Math.pow((1 + douAnualInterest), loanTerm * 12))
                / ((Math.pow((1 + douAnualInterest), loanTerm * 12)) - 1);

        return douPayAm;
    }

    public double total(){
        double douTotal = monthlyRate() * (loanTerm * 12);
        return douTotal;
    }
}
