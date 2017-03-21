import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by ovidiu.luchian on 17-Mar-17.
 * <p>
 * <p>
 * Test Case Summary: Test if adding to chart without selecting options triggers an alert.
 * <p>
 * Preconditions:
 * - User has access to www.marosbike.ro
 * <p>
 * <p>
 * Steps:
 * 1. Hover "Biciclete" menu
 * 2. Select "MTB XC hardtail 29R" menu
 * 3. Show details of a specific bike
 * 4. Add bike to chart.
 * <p>
 * <p>
 * Expected result:
 * The Cart Details should not be empty.
 * <p>
 * <p>
 * NOTE:
 * This is already a bug!
 */

public class AddToChart {
    static WebDriver chrome = new ChromeDriver();
    static WebDriverWait loadWait = new WebDriverWait(chrome, 20);

    @BeforeClass
    public static void precondtitions() {
        chrome.get("http://www.marosbike.ro/mtb-29er/bicicleta-cannondale-f29-carbon-4-2015.html");
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void driverClose() {
        chrome.quit();
    }

    void letterWait(String path) {
        //  Wait for newsletter popup and close it in case it appears.
        WebDriverWait newsWait = new WebDriverWait(chrome, 3);
        try {
            newsWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            chrome.findElement(By.xpath(path)).click();

        } catch (Throwable e) {
//            e.printStackTrace();
        }
    }

    @Before
    public void AddBikeToCart() {
        new Select(chrome.findElement(By.xpath("//*[@id='productCost']/form/select"))).selectByIndex(1);
        chrome.findElement(By.xpath("//*[@id='productCost']//*[text()='Adaugă în coş']")).click();
        letterWait("//*[@id='nl-headbar-close']");
    }


    @Test
    public void CheckCartDetailsUpdate() {
        Assert.assertFalse(chrome.findElement(By.xpath("//*[@id=\"cartDetails\"]//*/td")).getText()
                .equalsIgnoreCase("Coşul dumneavoastră este momentan gol!"));
    }

}


