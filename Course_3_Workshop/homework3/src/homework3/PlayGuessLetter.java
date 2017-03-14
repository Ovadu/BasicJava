package homework3;

import java.util.Scanner;

/**
 * Created by ovidiu.luchian on 28-Feb-17.
 */
public class PlayGuessLetter {
    static Scanner scan = new Scanner(System.in);
    static Letter game = new Letter();

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
            System.out.println(String.format("Pssst! The secret letter is %s. You're welcome!", (char) game.getSecretLetter())); //Cheats ON!
            System.out.println("Please enter a letter: ");
            game.setUserGuess(scan.next());
            game.incrementGuessCount();

            if ((int) game.getUserGuess() > (int) game.getSecretLetter()) {
                System.out.println("Your guess is alphabetically after the computer generated letter. Try again");
            } else if ((int) game.getUserGuess() < (int) game.getSecretLetter()) {
                System.out.println("Your guess is alphabetically before the computer generated letter. Try again");
            } else if ((int) game.getUserGuess() == (int) game.getSecretLetter()) {
                game.gameWin();
                restart();
                System.out.println("Your game is now reset!");
            }

        }
    }
}
