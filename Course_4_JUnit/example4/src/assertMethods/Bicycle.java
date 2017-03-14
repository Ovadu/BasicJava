package assertMethods;

public class Bicycle {

	int cadence;
	int speed;
	int gear;
	
	public Bicycle (int startCadence, int startSpeed, int startGear){
		cadence = startCadence;
		speed = startSpeed;
		gear = startGear;
	}
	
	public void changeCadence (int newValue){
		cadence = newValue;
	}
	
	//...
	public int getCadence (){
		return cadence;
	}
	
	//....
}
