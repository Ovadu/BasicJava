package exceptions;

public class ArithmeticExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1 = 32;
		int num2 = 2;
		int divide;
		
		try{
			divide = num1 / num2;
			System.out.println("Try block message: " + divide);
		} catch(Exception e){
			//this block is to catch divide-by-zero error
			System.out.println("Error: Don't divide a number by zero " + e);
		} finally{
			System.out.println("Executing no matter what happens in try/catch.");
		}
	}

}
