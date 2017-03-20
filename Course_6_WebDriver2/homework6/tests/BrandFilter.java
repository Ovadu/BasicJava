import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ovidiu.luchian on 17-Mar-17.
 * <p>
 *
 * Test Case Summary: Test if the sort selector sorts the items ascendant.
 *
 * Preconditions:
 *  - User has access to www.marosbike.ro
 *
 * Steps:
 * 1. Hover "Biciclete" menu
 * 2. Select "MTB XC hardtail 29R" menu
 * 3. In the "Sortare dupa:" drop-box, select "Pret asc"
 *
 * Expected result:
 * The item prices are ordered from the lowest to the highest.
 */

public class BrandFilter {
    static WebDriver chrome = new ChromeDriver();
    static WebDriverWait loadWait = new WebDriverWait(chrome, 20);


    @BeforeClass
    public static void precondtitions() {
        chrome.get("http://www.marosbike.ro/");
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loadWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Biciclete")));
        new Actions(chrome).moveToElement(chrome.findElement(By.linkText("Biciclete")))
                .moveToElement(chrome.findElement(By.xpath("//*[@id='menu']/ul/li/ul/ul/li/a[contains(@title, 'MTB XC hardtail 29R')]"))).click()
                .perform();

    }

//    @AfterClass
//    public static void driverClose() {
//        chrome.quit();
//    }

    @Before
    public void FindBike() {
        loadWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"available_filters\"]/li/a")));
        Assert.assertEquals("http://www.marosbike.ro/mtb-29er/", chrome.getCurrentUrl());
        chrome.findElement(By.xpath("//*[@id=\"available_filters\"]/li/a[contains(., 'Devron')]")).click();

        try {
            loadWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nl-headbar-close']")));
            chrome.findElement(By.xpath("//*[@id='nl-headbar-close']")).click();

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    @Test
    public void CheckIfOtherSizesAreAvailable() {

        List<WebElement> results = chrome.findElements(By.xpath("//*[@id=\"content\"]/div/div/div[@class='productName']/a"));
        int count = 0;
        for (WebElement we: results){
            count++;
            System.out.println(count + ". " + we.getText());
        }

    }
}
