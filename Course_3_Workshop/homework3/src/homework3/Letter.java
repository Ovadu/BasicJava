package homework3;

import java.util.Random;
import java.util.regex.*;

/**
 * Created by ovidiu.luchian on 27-Feb-17.
 */
public class Letter {
    //Create objects for random and scanner
    private static Random rand = new Random();

    //Computer and user picked letters
    private char secretLetter = (char) (rand.nextInt(26)+ 'a');
    private char userGuess;


    //Counters
    private int guessCount = 0;

    //Status
    private boolean win = false;

    //Guess:
    void setUserGuess(String arg){
        boolean b = Pattern.matches("[a-zA-Z]", arg);
        if (b && arg.length()==1) {
            String lower = arg.toLowerCase();
            userGuess = lower.toCharArray()[0];
        }
        else{
            System.out.println("Please make sure that you enter only ONE letter from a-z.");
            guessCount--;
        }
    }

    char getUserGuess(){
        return userGuess;
    }

    //Methods:
    //secretLetter:
    int getSecretLetter(){
        return secretLetter;
    }

    //guessCount:
    void incrementGuessCount(){
        this.guessCount++;
    }

    void gameWin(){
        win = true;
        System.out.println(String.format("Congrats! \nI was thinking of the letter: %s \nYou got it right in %s tries.", secretLetter, guessCount));
    }
    void gameReset(){
        guessCount = 0;
        win = false;
        secretLetter = (char) (rand.nextInt(26)+ 'a');
    }
    boolean getWin(){
        return win;
    }

}
