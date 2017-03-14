package introduction;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;

public class AssertThatExample2 {
	
    int numberOfCategories = 3;
    
	@Test
	public void testLoanTerm1 () {		
		Assert.assertThat(numberOfCategories, lessThanOrEqualTo(20));		
	}

}
