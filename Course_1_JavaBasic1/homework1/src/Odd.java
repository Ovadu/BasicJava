import java.util.Scanner;

public class Odd {

	public static void main(String[] args){
		System.out.println("Please enter a number: ");
		Scanner scan = new Scanner(System.in);
		interpret(scan.nextInt());
		scan.close();
	}
	

	private static void interpret(int intInput){
		/*
		 * I organized the interpreter and strings to a single function just to be more organized.
		 * 
		 * I hope you don't mind I changed the answers to something a bit more playful.
		 */
		String oddAnswer = String.format("You typed %s. I find that number very ODD.", intInput); 
		String evenAnswer = String.format("I know that %s is an EVEN number!", intInput);
		
		if(intInput % 2 == 1)
		{
			System.out.println(oddAnswer);
		} 
		else if(intInput %2 != 1)
		{
			System.out.println(evenAnswer);
		}
	}
	
}

