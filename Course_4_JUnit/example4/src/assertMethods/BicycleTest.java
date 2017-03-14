package assertMethods;

import org.junit.AfterClass;
import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class BicycleTest { 

	static Bicycle bike;
	
	//@BeforeClass must be static because, by design,
	//there is no instance of the class to invoke the @BeforeClass method on
	@BeforeClass
	public static void beforeClass (){
		bike = new Bicycle (20, 8, 5);
	}	
	
	@Test
	public void testChangeCadence() {
		bike.changeCadence(55);
		Assert.assertEquals(55, bike.getCadence());
	}
	
	@AfterClass
	public static void afterClass(){
		bike = null;
	}

}

