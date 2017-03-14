package introduction;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class AssertThatExample {

	 @Test
	 public void testWithMatchers() {
	      Assert.assertThat("this string", is("this string"));
	      Assert.assertThat(123, is(123));
	 }

}
