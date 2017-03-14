package homework4;

/**
 * Created by ovidiu.luchian on 15-Feb-17.
 */
public class TestLoanCalculator {
    public static void main (String[] args) {
        //Calculate with valid data
        try {
            LoanCalculator loanv1 = new LoanCalculator(30000, 5, 12);

            int intLoanAmount = loanv1.getLoanAmount();
            int intLoanTerm = loanv1.getLoanTerm();
            double douInterest = loanv1.getInterest();

            System.out.println(String.format("You entered: \nLoan amount: %s \nLoan term: %s \nInterest: %s \n", intLoanAmount, intLoanTerm, douInterest));

            double douMonRate = loanv1.monthlyRate();
            double douTotal = loanv1.total();

            System.out.println(String.format("Monthly rate: %s \nTotal payed: %s \n------------------------------------", douMonRate, douTotal));
        } catch (Exception ex) {
            System.out.println("Please verify if the entered data is valid! " + ex);
        }


        //An attempt to calculate with invalid data
        try {
            LoanCalculator loanf1 = new LoanCalculator(30000, 5, 112);

            int intLoanAmount = loanf1.getLoanAmount();
            int intLoanTerm = loanf1.getLoanTerm();
            double douInterest = loanf1.getInterest();

            System.out.println(String.format("You entered: \nLoan amount: %s \nLoan term: %s \nInterest: %s \n\n", intLoanAmount, intLoanTerm, douInterest));

            double douMonRate = loanf1.monthlyRate();
            double douTotal = loanf1.total();

            System.out.println(String.format("Monthly rate: %s \nTotal payed: %s \n------------------------------------", douMonRate, douTotal));

        } catch (Exception ex) {
            System.out.println("Please verify if the entered data is valid! " + ex);
        }

    }

}