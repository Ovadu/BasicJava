package arrayAndCollections;

public class Bicycle {
	
		// TODO Auto-generated constructor stub

		int cadence = 0; 
		int speed = 0; 
		int gear = 1;

		public Bicycle(int startCadence, int startSpeed, int startGear){
			cadence = startCadence;
			speed = startSpeed;
			gear = startGear;
		}
		
		void changeCadence(int newValue){
			cadence = newValue;
		}
		
		public int getCadence(){
			return cadence;
		}
}
