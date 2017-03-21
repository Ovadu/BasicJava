import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
 * Steps:
 * 1. Hover "Biciclete" menu
 * 2. Select "MTB XC hardtail 29R" menu
 * 3. Show details of a specific bike
 * 4. Add bike to chart.
 * <p>
 * Expected result:
 * An alert is triggered.
 */

public class CheckAlert {
    static WebDriver chrome = new ChromeDriver();
    static WebDriverWait loadWait = new WebDriverWait(chrome, 20);
    static String tab1;


    @BeforeClass
    public static void precondtitions() {
        chrome.get("http://www.marosbike.ro/");
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tab1 = chrome.getWindowHandle();

        loadWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Biciclete")));
        new Actions(chrome).moveToElement(chrome.findElement(By.linkText("Biciclete")))
                .moveToElement(chrome.findElement(By.xpath("//*[@id='menu']/ul/li/ul/ul/li/a[contains(@title, 'MTB XC hardtail 29R')]"))).click()
                .perform();
        loadWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"available_filters\"]/li/a")));
        Assert.assertEquals("http://www.marosbike.ro/mtb-29er/", chrome.getCurrentUrl());


    }

    @AfterClass
    public static void driverClose() {
        chrome.quit();
    }

    @Before
    public void AddToCart() {
        chrome.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[@class='productName']/a[@title='Bicicleta Focus Raven Max Team 29 11G 2016']")).click();

        //  Wait for newsletter popup and close it in case it appears.
        try {
            loadWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nl-headbar-close']")));
            chrome.findElement(By.xpath("//*[@id='nl-headbar-close']")).click();

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    //    Create a method that returns true if alert is present
    public boolean isAlertPresent() {
        try {
            chrome.switchTo().alert();
            return true;
        } // try
        catch (Exception e) {
            return false;
        } // catch
    }

    @Test
    public void CheckIfAlertAppears() {
        chrome.findElement(By.xpath("//*[@id='productCost']//*[text()='Adaugă în coş']")).click();
        Assert.assertTrue(isAlertPresent());
    }

}


