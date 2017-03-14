import java.util.*;

public class WordSort {

	public static void main(String[] args) 
	{
		ArrayList<String> typedAll = new ArrayList<String>(); //create an empty array

		System.out.println(String.join("\n", 				  //print the instructions
				"Please type a word and press enter.", 
				"Press enter twice for exit."));


		Scanner scan = new Scanner(System.in);				  //create and initialize the scanner
		String typed = new String();						  //create and initialize an empty string to store the line

		do 
		{
			typed = scan.nextLine();						  //moves to the next token in the scanner
			typedAll.add(typed);							  //adds the current value to the array

		} while (typed.length() != 0);                        //verifies the length of the typed string and decides if the execution will continue

		scan.close();										  //closes the scanner
		Collections.sort(typedAll, String.CASE_INSENSITIVE_ORDER); //sorts the list alphabetically


		for (String word : typedAll) 						  //iterates the strings in the list
		{
			System.out.println(word);						      //prints each word to the console
		}

	}


}
