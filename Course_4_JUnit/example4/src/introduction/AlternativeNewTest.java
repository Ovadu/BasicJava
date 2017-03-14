package introduction;


import static org.junit.Assert.*;
//The static import feature allows to access the static members of a class without the class qualification.
import org.junit.Test;

public class AlternativeNewTest {

	@Test
	public void test() {
		int x=5+6;
		//Assert.assertEquals(11, x);
		assertEquals(11, x);
	}

}
