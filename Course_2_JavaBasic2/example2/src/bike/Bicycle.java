package bike;

public class Bicycle {
	
	int cadence; 
	int speed; 
	int gear;
	
	/*public Bicycle(int startCadence, int startSpeed, int startGear){
		cadence = startCadence;
		speed = startSpeed;
		gear = startGear;
	}*/
	
	public Bicycle(int cadence, int speed, int gear){
		this.cadence = cadence;
		this.speed = speed;
		this.gear = gear;
	}
	
	void changeCadence (int newValue){
		cadence = newValue;
	}
	
	/*int change(){
		return cadence;
	}*/
	
	void changeGear(int newValue){
		gear = newValue;
	}
	
	void speedUp(int increment){
		speed = speed + increment;
	}
	
	void applyBrakes(int decrement){
		speed = speed - decrement;
	}
	
	void printStates(){
		System.out.println("cadence:" + cadence + " speed:" + speed + " gear:" + gear);
	}
	
	//overridden equals() method to check if two objects are equal based on the values of their instance
	//variables. Two objects may be stored at different memory addresses but may still be equal base 
	//on their instance variable.
	public boolean equals(Object obj) {
	    //null instanceof Object will always return false
	    if (!(obj instanceof Bicycle))
	    {
	      return false;
	    }
	    if (obj == this) //verifies if current instance (this) has the same memory address with the object passed as parameter
	    {
	      return true;
	    }
	    return  this.cadence == ((Bicycle) obj).cadence &&
	            this.gear == ((Bicycle) obj).gear &&
	            this.speed == ((Bicycle) obj).speed;
	  }
}
