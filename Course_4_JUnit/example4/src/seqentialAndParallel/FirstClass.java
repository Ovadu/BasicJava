package seqentialAndParallel;

import org.junit.Assert;
import org.junit.Test;

public class FirstClass {
	
	/*@Before
	public void testBefore(){
		System.out.println("This will execute before each test");
	}*/
	
	@Test
	public void testFirst1() {
		int x=5+6;
		Assert.assertEquals(11, x);
		System.out.println("testFirst1 - Thread id: [" + Thread.currentThread().getId() + "]");
	}
	
	@Test
	public void testSecond1() {
		int x=6+6;
		System.out.println("testSecond1 - Thread id: [" + Thread.currentThread().getId() + "]");
		Assert.assertEquals(11, x);

	}

	@Test
	public void testThird1() {
		int x=5+6;
		Assert.assertTrue(11==x);
		System.out.println("testThird1 - Thread id: [" + Thread.currentThread().getId() + "]");
	}
	
}
