public class AverageArray {

	public static void main(String[] args) {
		int[] intArray = {16, 0, 33, -4, 21, 5, 8, 12};
		int sum = 0;
		double average = 0d;
		
		for(int i = 0; i < intArray.length; i++){
			sum = sum + intArray[i];
		}
		
		/*
		 * Calculate the average. 
		 * The (double) cast is used to convert the sum to double to prevent loss of precision
		 */
		average = ((double)sum) / intArray.length;  
		
		System.out.printf("The average of the array is %s :).", average); 
		//I find using printf or String.format or System.out.format much cleaner than concatenating a bunch of strings.
	}

}
