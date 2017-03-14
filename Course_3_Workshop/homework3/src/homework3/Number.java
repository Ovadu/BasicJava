package homework3;

import java.util.Random;


/**
 * Created by ovidiu.luchian on 27-Feb-17.
 */
public class Number {
    //Create objects for random and scanner
    private static Random rand = new Random();

    //Implement level selectors (for no good reason)
    private int level = 11;

    //Computer and user picked numbers
    private int secretNumber = rand.nextInt(level);

    //Counters
    private int guessCount = 0;

    //Status
    private boolean win = false;

    //Methods:
    //level:
    void setLevel(int level){
        this.level = level + 1;
    }
    int getLevel(){
        return level - 1;
    }

    //secretNumber:

    int getSecretNumber(){
        return secretNumber;
    }

    //guessCount:
    void incrementGuessCount(){
        this.guessCount++;
    }

    //win:
    void gameWin(){
        win = true;
        System.out.println(String.format("Congrats! \nI was thinking of number: %s \nYou got it right in %s tries.", secretNumber, guessCount));
    }
    void gameReset(){
        guessCount = 0;
        win = false;
        secretNumber = rand.nextInt(level);
    }
    boolean getWin(){
        return win;
    }

}
