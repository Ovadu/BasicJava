package seqentialAndParallel;

import org.junit.Assert;
import org.junit.Test;

public class SecondClass {

	/*@Before
	public void testBefore(){
		System.out.println("This will execute before each test");
	}*/
	
	@Test
	public void testFirst2() {
		int x=6-3;
		Assert.assertEquals(3, x);
		System.out.println("testFirst2 - Thread id: [" + Thread.currentThread().getId() + "]");
	}
	
	@Test
	public void testSecond2() {
		int x=6-2;
		System.out.println("testSecond2 - Thread id: [" + Thread.currentThread().getId() + "]");
		Assert.assertEquals(5, x);
	}

	@Test
	public void testThird2() {
		int x=6-1;
		Assert.assertTrue(5==x);
		System.out.println("testThird2 - Thread id: [" + Thread.currentThread().getId() + "]");
	}
}
