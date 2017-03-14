package operators;

public class IncrementOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int c = 0;
		int d = 0;
		int result1 = c + (d++); //d becomes 1 AFTER the operation
		System.out.println("Result1: " + result1); 
		
		int a = 0;
		int b = 0;
		int result2 = a + (++b); // b becomes 1 BEFORE the operation
		System.out.println("Result2: " + result2); 
	}
}
