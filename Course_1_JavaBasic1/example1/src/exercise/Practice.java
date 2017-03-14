package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice {
	final static float flVal = 123456.44f;
	
	public static void main(String[] args) {

		//declare a variable of type String
		String strName = "ana";
		
		//declare a constant of type float
		
		//print the variable and constant created before on separate lines
		System.out.println("The variable is: " + strName + "\nThe constant is: " + flVal);
		
		//declare an ArrayList which contains 5 items of type String and sort them in alphabetical order using Collection
		ArrayList<String> words = new ArrayList<String>();
		 
		words.add("aaaaa");
		words.add("zzzzz");
		words.add("123aasa");
		words.add("Bbbb");
		words.add("ssss");
		
		Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
		
		for (int i=0; i< words.size(); i++){
			System.out.println(words.get(i));
		}
		
		//the letters from 'a to z' have different ASCII codes from 'A to Z'	
		//https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
		
		//Ask the user for a number. Write and read the number from console using Scanner
		//https://docs.oracle.\com/javase/8/docs/api/java/util/Scanner.html

		System.out.println("Please write a number: ");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.println("The number is: " + number);
		
		scan.close();

	}

}
