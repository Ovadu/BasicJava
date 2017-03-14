package exercise;

import org.junit.*;
import org.junit.rules.ErrorCollector;

public class EmployeeTest {
	static Employee alex;
	static Employee bogdan;

	//create a test for getID() method
	@Test
	public void testGetID(){
		Employee ovidiu = new Employee(51665, "Ovidiu Luchian", "Testing Automation");
		Assert.assertEquals(51655, ovidiu.getID());
	}

	//make another test method for getID(), but use @BeforeClass for creating an object
	//test the getID() using AssertTrue annotation
	@BeforeClass
	public static void createTestOject(){
		alex = new Employee(123456, "Alex Hrin", "Testing Automation");
	}
	
	@Rule
	public ErrorCollector theErrors = new ErrorCollector();
	
	@Test
	public void testGetIDTrue(){
		try{
		Assert.assertTrue(alex.getID() == 123456);
		} catch (Throwable t) {
			theErrors.addError(t);
		}
		
		try{
		Assert.assertEquals("Alex Hrin", alex.myName);
		} catch (Throwable t) {
			theErrors.addError(t);
		}
		
		try{
		Assert.assertFalse(alex.myDepartment.equals("Testin Automation"));
		} catch (Throwable t) {
			theErrors.addError(t);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testErrors(){
		bogdan = new Employee(-151988, "Bogdan Diaconu", "Testing Automation");
		}
	//in the same test method, use AssertEquals and assertFalse annotations in order to test also the department and name
	//Use @Rule for multiple Asserts

	//make another test method in order to test the exceptions from the constructor

	//create an @AfterClass method in order to make all the objects null
	
	@AfterClass
	public static void deleteAllObj(){
		alex = null;
		bogdan = null;
	}

}
