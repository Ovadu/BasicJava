import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Created by ovidiu.luchian on 20-Mar-17.
 */

@RunWith(Suite.class)
@SuiteClasses({
        PriceSort.class,
        BrandFilter.class,
        MultipleBrandsFilter.class,
        CheckAlert.class,
        AddToChart.class
})

public class RunSequentially{
}
