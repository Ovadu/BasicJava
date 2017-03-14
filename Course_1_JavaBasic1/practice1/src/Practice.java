import java.util.*;

public class Practice {
	final static float weight = 117.3f;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strName = "Ovidiu";
		
		System.out.println("The var is: " + strName + "\nThe constant is: " + weight);
		
		
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Alin");
		names.add("Bogdan");
		names.add("Andrei");
		names.add("Radu");
		names.add("Ana");
		names.add("Oana");
		names.add("Alex");
		names.add("Ovidiu");
		
		Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
		
		for (int i=0; i<names.size(); i++){
			System.out.println(names.get(i));
			
		System.out.println("Please write a number: ");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.println("The number is: " + number);	
		
		
		}
	}

}
