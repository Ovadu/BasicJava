package paramaterized;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import assertMethods.Bicycle;

@RunWith (Parameterized.class)
public class BicycleParameterized {
	
	private Bicycle bike;
	private int expectedCadence;
	
	//the constructor that will change the values of the global parameters with each call
	public BicycleParameterized(Bicycle newBike, int newCadence)
	{
		bike = newBike;
		expectedCadence = newCadence;
	}
	
	//the static method with the parameters that will be passed on the constructor
	@Parameters
	public static Collection<Object[]> gettingTheParameters()
	{
		Object[][] myParameters = new Object[][]{
			{new Bicycle(23, 10, 7), 23},
			{new Bicycle(54, 10, 6), 55},
			{new Bicycle(48, 10, 8), 48},
		};
		return Arrays.asList(myParameters);
	}
	
	//the test method that will be executed as many times as the parameters
	@Test
	public void verifyCadence()
	{
		double actualCadence = bike.getCadence();
		Assert.assertEquals(expectedCadence, actualCadence, 0); // delta is the maximum allowed absolute difference between actual and expected value
		System.out.println("The cadence was tested.");
	}

}
