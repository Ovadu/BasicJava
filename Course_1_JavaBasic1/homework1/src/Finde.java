public class Finde {

	public static void main(String[] args) 
	{
		String findIn = "Search this string for letter e!"; //The string that we are searching in
		char find = 'e'; //The search term
		int count = 0; //The number of search results of the find term in the findIn string

		for (int i=0; i < findIn.length(); i++ ){
			char found = findIn.charAt(i); //Returns each character in the findIn string
			
			if(found == find)
			{ //If the 'current character' is the same as 'the search term', increments i
				count++;
			}
		}
		
		System.out.format("The letter 'e' has been found %s times.", count); //Prints the count in the console
	}

}
