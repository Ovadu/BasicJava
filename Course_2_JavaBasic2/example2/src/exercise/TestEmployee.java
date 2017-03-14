package exercise;

//make a test class which test the constructor
public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create a new object in order to test the constructor
		Employee ovidiu = new Employee (25614761, "Ovidiu Luchian", "Testing");
		
		//change the department to "HR"
		ovidiu.myDepartment = "HR";
	
		//print the new department
		System.out.println("The new department is: " + ovidiu.myDepartment);
		
		//create another object which test the exception from the constructor
		//use try-catch block in order to catch the exception
		try{
			Employee alex = new Employee (-5, "Alex", "Testing");
		}catch(IllegalArgumentException ex){
			System.out.println("Please do not enter IDs <= 0 " + ex);
		}
		
		//test the getEmpID() method
		System.out.println("The ID is: " + ovidiu.getID());
		
			
	}

}
