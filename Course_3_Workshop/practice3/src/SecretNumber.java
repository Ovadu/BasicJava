import java.util.Random;
import java.util.Scanner;

/**
 * Created by ovidiu.luchian on 23-Feb-17.
 */
public class SecretNumber {
    public static void main (String[] args){
        Random rand = new Random();
        int secretNumber = rand.nextInt(11);

        int guessCount = 0;

        System.out.println("Please enter a number between 0 and 10:");
        Scanner scan = new Scanner(System.in);

        int guess;

        do {
            guess = scan.nextInt();
            if (guess == secretNumber){
                System.out.println("Congrats!");
                System.out.println("I was thinking about the number: " + secretNumber);
                System.out.println("You got it right in " + guessCount);

                System.out.println("Would you like to play again? (Y/N):");
                String answer = scan.next();
                if (answer.equalsIgnoreCase("y"))
                {
                    System.out.println("Game is restarting...");
                    secretNumber = rand.nextInt(11);
                    guessCount = 0;
                    guess = scan.nextInt();
                    continue;
                }
                else if (answer.equalsIgnoreCase("n"))
                {
                    System.out.println("Game over!");
                    return;
                }
            }
            else if (guess > secretNumber)
            {
                System.out.println("The entered number is too high!");
            }
            else if (guess < secretNumber)
            {
                System.out.println("The entered number is too low!");
            }
            guessCount++;
        } while (guess != secretNumber);

        scan.close();


    }
}
