package rule;

import org.junit.Assert;
import org.junit.Test;

public class ClassWithoutRule {
	
	int firstNo = 5;
	int secondNo = 9;
	
	@Test
	public void test(){
		Assert.assertEquals(firstNo, secondNo); //because the first Assert fails, the other two are not executed
		Assert.assertTrue(firstNo>secondNo);
		Assert.assertTrue(firstNo<secondNo);
	}
	

}
