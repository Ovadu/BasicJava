package controlFlow;

public class BreakExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [][] arrayIntegers = {{88,  6, 25, 11},
								  {23, 91,  9, 20},
								  { 7, 17, 38, 17},
								  {17, 31, 17, 55}};

		int find = 17;
		
		for (int i = 0; i<arrayIntegers.length; i++){
			for(int j = 0; j<arrayIntegers[i].length; j++){ //search on the line 
				if(arrayIntegers[i][j]==find){ //verify on the current position if the value "17" exists
					System.out.println(i + " " + j); //if it is find, will print [i] [j] and 
					break; //will never search on this line because of "break" statement
				}
			}
		}
	}

}
