package arrayAndCollections;

import java.util.ArrayList;

public class FruitsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> fruits = new ArrayList<String>();
		 
		fruits.add("Pineapple");
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");
		
		for(String temp: fruits){
			System.out.println(temp);
		}
		
		System.out.println(fruits.size());
		System.out.println("Display the remaining fruits: ");
		fruits.remove(1);
		for(String temp: fruits){
			System.out.println(temp);
		}
		
		fruits.add(2, "Cherry"); //we can add elements everywhere in the list
		System.out.println("The fruits are: ");
		for(int i = 0; i < fruits.size(); i++ )
		{
			System.out.println(fruits.get(i));
		}
		
		
	}
}
