package bike;

public class BicycleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create two different Bicycle objects
		
		//if we don't create a constructor:
		/*Bicycle biken = new Bicycle(); //without arguments
		biken.cadence = 30;
		biken.speed = 0;
		biken.gear = 8;*/
		
		Bicycle myBike = new Bicycle(30, 0, 8);
		Bicycle yourBike = new Bicycle (10, 0, 5);
		
		int c = myBike.cadence;
		int s = myBike.speed;
		int g = myBike.gear;
		
		
		//Invoce methods on those objects
		myBike.changeCadence(50);
		myBike.speedUp(10);
		myBike.changeGear(2);
		myBike.printStates();
		
		//Comparing Objects
		Bicycle bike1 = new Bicycle(0, 0, 1);
		Bicycle bike2 = new Bicycle(0, 0, 1);
		
	//	if(bike1==bike2) //false // compares the memory addresses of the objects
	/*	if(bike1.equals(bike2)) //using the implicit method equals
		{
			System.out.println("bike1 equal to bike2");
		}
		else{
			System.out.println("bike1 not equal to bike2");
		}*/
		
		/*
		Bicycle bike3 = new Bicycle(0, 0, 1);
		Bicycle bike4 = bike3; 
		
		if(bike3==bike4) //true
		//cele doua referinte indica acelasi obiect
		{
			System.out.println("bike3 equal to bike4");
		}
		else{
			System.out.println("bike3 not equal to bike4");
		}*/
		
		
		//using the overriden method equals() from Bicycle class
		if(bike1.equals(bike2)){
			System.out.println("bike1 equal to bike2");
		}
		else{
			System.out.println("bike1 not equal to bike2");
		}
	}
}
