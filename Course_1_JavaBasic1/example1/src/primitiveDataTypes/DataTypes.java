package primitiveDataTypes;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean b = true;
		char c = 'x';
		
		byte i = 2;
		short j = 5;
		int k = 7;
		//long l = 123456;
		long l = 9223372036854L; //with "L" at the end - because it is outside of int range: [-2,147,483,648, 2,147,483,647]
								//if there is no suffix, and it is an integral type (e.g. 123456), it is assumed to be an int
								//and it will work because it is automatically converted from int to long

		//in Java, when you type a decimal number as 5.5, its interpreted as a double. 
		//double is a 64-bit precision IEEE 754 floating point, while float is a 
		//32-bit precision IEEE 754 floating point.
		//As a float is less precise than a double, the conversion cannot be performed implicitly.
		//If you want to create a float, you should end your number with f (i.e.: 3.6f).
		float f = 5.5f;
		//float f = (float)5.5;
		double d = 7.7; 
		//double d1 = 6.0;
		
		System.out.println("The values are: " + b + ", " + c + ", " + i + ", " + j + ", " 
		+ k + ", "+ l + ", " + f + ", " + d);
	}

}
