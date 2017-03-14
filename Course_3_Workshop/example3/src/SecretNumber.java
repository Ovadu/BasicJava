import java.util.Random;
import java.util.Scanner;

public class SecretNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		//int secretNumber = (int) (Math.random() * 9 + 1);
		int secretNumber = rand.nextInt(11); 

		int guessCount = 0;
		System.out.println("Guess the number between 0 and 10");

		Scanner scan = new Scanner(System.in);
		
		boolean win = false;
		
		while (win == false){
			
			int guess = scan.nextInt();
			guessCount++;
			
			if(guess == secretNumber){
				System.out.println("Congrats");
				System.out.println ("I was thinking of the number: " + secretNumber + ".");
				System.out.println("You got it right in " + guessCount + " guesses");
				win = true;
				
				//play again or game over
				System.out.println("Do you want to play again? (Y / N)");
				String myStr = scan.next();
				
				if(myStr.equalsIgnoreCase("Y")){
					System.out.println("Playing again...guess the number");
					secretNumber = rand.nextInt(11); 
					win = false;
					guessCount = 0;
				}
				else if (myStr.equalsIgnoreCase("N")){
					System.out.println ("Game over");
				}
			}

			else if(guess < secretNumber){
				System.out.println("Too low");
			}

			else if(guess > secretNumber){
				System.out.println("Too high");
			}
		}
		
		scan.close();
	}

}
