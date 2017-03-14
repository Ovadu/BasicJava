package casting;

public class MountainBike extends Bicycle {

	static final int WHEEL_SIZE = 29;
	
	public void printWheelSize(){
		System.out.println("All mountain bikes have " + WHEEL_SIZE + " inch");
	}
	
	//method overriding - methods with same name and same signature
	public void printStates()
	{
		System.out.println("cadence is: " + cadence + " wheelSize: " + WHEEL_SIZE);
	}

}
