package paramaterized;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith (Parameterized.class)
public class JUnitParameterized {
	private int x;
	private int y;
	//add sum example
	private int sum;
	
	////the constructor that will change the values of the instance variables with each call
	public JUnitParameterized (int x, int y, int sum){ 
		this.x=x; //this refers to the current instance
		this.y=y;
		this.sum = sum;
	}
	
	@Parameterized.Parameters
	public static Collection<Integer[]> ids(){ //this method returns a Collection of Array as test data set
		return Arrays.asList(new Integer[][]{
			{1, 2, 3}, //0
			{3, 3, 5}, //1
			{1, 5, 9}, //2
			{7, 8, 15}, //3
			{2, 2, 4}, //4
			{5, 5, 1}, //5
			{8, 9, 0}, //6
			{1, 1, 5}  //7
		});
	}

	//this test will run 8 times 
	@Test
	public void testText() {
		//here we will use the instance variables
		//Assert.assertEquals(x,y); 
		Assert.assertEquals(sum , x+y);
	}

}
