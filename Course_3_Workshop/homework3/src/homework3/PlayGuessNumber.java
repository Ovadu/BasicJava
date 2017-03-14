package homework3;

import java.util.Scanner;

/**
 * Created by ovidiu.luchian on 27-Feb-17.
 */
public class PlayGuessNumber {
    static Scanner scan = new Scanner(System.in);
    static Number game = new Number();

    //Method that asks the user for another game and allows only 3 invalid inputs.
    public static void restart(){
        System.out.println("Would you like to play again? (Y/N):");
        String answer = scan.next();

        for(int i=3; i!=0; i--) {
            if (answer.equalsIgnoreCase("y"))
            {
                game.gameReset();
            }
            else if (answer.equalsIgnoreCase("n"))
            {
                System.out.println("Game over!");
                scan.close();
                System.exit(1);
            } else {
                System.out.println(String.format("Invalid selection, you have %s more tries.", i));
                answer = scan.next();
            }
        }
    }

    //Main game loop
    public static void main(String[] args){
        while (!game.getWin()) {
            System.out.println(String.format("Pssst! The secret number is %s. You're welcome!", game.getSecretNumber())); //Cheats ON!
            System.out.println(String.format("Please enter a number between 0 and %s:", game.getLevel()));
            int userGuess = scan.nextInt();
            game.incrementGuessCount();

            if (userGuess > game.getSecretNumber()) {
                System.out.println("The entered number is too high!");
            } else if (userGuess < game.getSecretNumber()) {
                System.out.println("The entered number is too low!");
            } else if (userGuess == game.getSecretNumber()) {
                game.gameWin();
                restart();
                System.out.println("Your game is now reset!");
            }

        }
    }
}
