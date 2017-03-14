package exercise;

public class Employee {

	//create a constructor for class Employee which take 3 arguments:
	// - an integer representing the ID
	// - a string representing the name
	// - a string representing the department
	int myID;
	String myName;
	String myDepartment;

	public Employee(int iD, String name, String department)
	{
		myID = iD;
		myName = name;
		myDepartment = department;
		
		//inside the constructor, print to the console all the declared variables
		System.out.println("The ID is: " + myID + "\nThe name is: " + myName + "\nThe department is: " + myDepartment);
	
		//if ID <=0, the constructor should throw an IllegalArgumentException
		if (myID <= 0)
		{
			 throw new IllegalArgumentException();
		}
	}

	//create a method which returns the ID
	public int getID(){
		return myID;
	}
}
