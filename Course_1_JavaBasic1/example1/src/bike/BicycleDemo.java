package bike;

public class BicycleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//Create two different Bicycle objects
		Bicycle bike1 = new Bicycle();
		bike1.cadence = 10;
		
		Bicycle bike2 = new Bicycle();
		bike2.cadence = 30;
		
		//Invoke methods on those objects
		bike1.changeCadence(50);
		bike1.speedUp(10);
		bike1.changeGear(2);
		bike1.printStates();
		
		bike2.changeCadence(40);
		bike2.speedUp(20);
		bike2.changeGear(3);
		bike2.printStates();
		
		//bike2.speedUp(10);
		//bike2.printStates();
		
		//Bicycle.numGears = 5; //compiler error
		
		//System.out.println(Bicycle.numGears); //Static fields are located in the class, so you 
									//don't need an instance of the class to access static fields. 
	}

}
