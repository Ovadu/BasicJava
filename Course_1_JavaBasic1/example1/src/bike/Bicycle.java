package bike;

public class Bicycle {

	int cadence = 0; 
	int speed = 0; 
	int gear = 1;

	final static int numGears = 6; //the same number of gears will be applied to all instances
	//we can also apply final keyword to indicate that number of gears will never modify = 
	//= this property is a constant

	void changeCadence (int newValue){
		cadence = newValue;
	}

	void changeGear(int newValue){
		gear = newValue;
	}

	/*static void changeNumGears(int newNumGearsValue){
		numGears = newNumGearsValue;
	}*/

	void speedUp(int increment){
		speed = speed + increment;
	}

	void applyBrakes(int decrement){
		speed = speed - decrement;
	}

	void printStates(){
		System.out.println("cadence:" + cadence + " speed:" + speed + " gear:" + gear);

		//String message = "cadence:" + cadence + " speed:" + speed + " gear:" + gear; //local variable
		//System.out.println(message);
	}

	/*void printMessage(){
		//System.out.println(message);
	}*/
}
