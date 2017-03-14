package introduction;

import org.junit.Assert;
import org.junit.Test;

public class RandomOrderTests {
	
		@Test
		public void testFirst1() {
			int x=5+6;
			Assert.assertEquals(11, x);
		}
		
		@Test
		public void testSecond1() {
			int x=5+6;
			Assert.assertEquals(10, x);
		}

		@Test
		public void testThird1() {
			int x=5+6;
			Assert.assertTrue(11==x);
		}
		
		@Test
		public void testFirst2() {
			int x=6-3;
			Assert.assertEquals(3, x);
		}
		
		@Test
		public void testSecond2() {
			int x=6-2;
			Assert.assertEquals(5, x);
		}

		@Test
		public void testThird2() {
			int x=6-1;
			Assert.assertTrue(5==x);
		}

}
