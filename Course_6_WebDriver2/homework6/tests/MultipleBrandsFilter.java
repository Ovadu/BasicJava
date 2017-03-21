import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ovidiu.luchian on 17-Mar-17.
 * <p>
 * <p>
 * Test Case Summary: Test if selecting multiple bike brands is possible.
 * <p>
 * Preconditions:
 * - User has access to www.marosbike.ro/mtb-xc-hardtail/
 * <p>
 * Steps:
 * 1. From the filter list select at least 3 bike brands
 * <p>
 * Expected result:
 * The user can select more than 3 brands.
 *
 * NOTE: This test fails because there is a bug in the website.
 */

public class MultipleBrandsFilter {
    static WebDriver chrome = new ChromeDriver();
    static WebDriverWait loadWait = new WebDriverWait(chrome, 20);

    @BeforeClass
    public static void precondtitions() {
        chrome.get("http://www.marosbike.ro/mtb-xc-hardtail/");
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

    @Test
    public void CheckForError404() {
        List<String> brands = new ArrayList<>(Arrays.asList("Giant", "KTM", "FOCUS"));
        for (String brand : brands) {
            try {
                loadWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='available_filters']/li/a")));
                chrome.findElement(By.xpath("//*[@id=\"available_filters\"]/li/a[contains(., '" + brand + "')]")).click();

                letterWait("//*[@id='nl-headbar-close']"); // Wait for newsletter popup and close it in case it appears.
            } catch (Throwable t) {
                Assert.assertFalse(chrome.findElement(By.xpath("//*[@id='pageContent']//*/div[@id='error404']")).getText().contains("nu mai este disponibil"));
            }
        }

//        Force the test in case list is shorter than 3
        System.out.println(brands.size());
            if(brands.size()<=3) {
                Assert.assertFalse(chrome.findElement(By.xpath("//*[@id='pageContent']//*/div[@id='error404']")).getText().contains("nu mai este disponibil"));}

    }
}

