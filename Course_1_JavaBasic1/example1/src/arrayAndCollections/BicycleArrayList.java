package arrayAndCollections;

import java.util.ArrayList;
import java.util.List;

public class BicycleArrayList {

	public BicycleArrayList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Bicycle bike1 = new Bicycle(10, 0, 5);
		Bicycle bike2 = new Bicycle(20, 0, 5);
		Bicycle bike3 = new Bicycle(30, 0, 5);
		Bicycle biken = new Bicycle(40, 0, 5);
		
		List<Bicycle> list = new ArrayList<Bicycle>();
		
		list.add(bike1);
		list.add(bike2);
		list.add(bike3);
		list.add(biken);
		
		for(Bicycle bicycle: list){
			System.out.println(bicycle.getCadence());
		}
		
		/*
		Bicycle[] bikes = new Bicycle[4];
		
		Bicycle bike1 = new Bicycle(10, 0, 5);
		Bicycle bike2 = new Bicycle(20, 0, 5);
		Bicycle bike3 = new Bicycle(30, 0, 5);
		Bicycle bike4 = new Bicycle(40, 0, 5);
		
		bikes[0]=bike1;
		bikes[1]=bike2;
		bikes[2]=bike3;
		bikes[3]=bike4;
		
		//System.out.println(bikes[2].getCadence());
		//Arrays.fill(bikes, new Bicycle(10, 0, 5));

		for(int i=0; i<bikes.length; i++)
		{
			System.out.println("This is a bicycle with cadence: " + bikes[i].getCadence());
		}
		*/
	}

}
