package casting;

public class UseBicycles {

	public static void main(String[] args) {		
		// TODO Auto-generated method stub

		Bicycle bike1 = new MountainBike(); //implicit casting; bike1 sees methods from Bicycle class only.
		bike1.cadence = 20;
		bike1.printStates(); //overriding, the child method always overrides the parent method

		/*Bicycle bike2 = new RoadBike();
		Bicycle bike3 = new MaleRoadBike();
		
		Bicycle[] arrayBicycles= {bike1, bike2, bike3}; //another way for implicit casting
		for(Bicycle b: arrayBicycles){
			b.printStates();
		}*/
	
		MountainBike myBike = (MountainBike) bike1; //explicit casting - after an implicit casting always; used to see methods from MountainBike class
		//In this case the variable bike1 is of type Bicycle but contains an object of type MountainBike
		myBike.printWheelSize();
	}
}

