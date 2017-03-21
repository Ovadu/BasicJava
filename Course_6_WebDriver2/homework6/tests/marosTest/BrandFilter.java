package marosTest;

import org.junit.*;
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
 * <p>
 * Test Case Summary: Test if the list contains other entries than the requested ones.
 * <p>
 * Preconditions:
 * - User has access to www.marosbike.ro
 * <p>
 * Steps:
 * 1. Hover "Biciclete" menu
 * 2. Select "MTB XC hardtail 29R" menu
 * 3. In "Producator" filter, select "Devron" brand
 * <p>
 * Expected result:
 * The list only contains "Devron" bikes.
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

    @AfterClass
    public static void driverClose() {
        chrome.quit();
    }

    void letterWait(String path){
        //  Wait for newsletter popup and close it in case it appears.
        WebDriverWait newsWait = new WebDriverWait(chrome, 3);
        try {
            newsWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            chrome.findElement(By.xpath(path)).click();

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Before
    public void FindBike() {
        loadWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"available_filters\"]/li/a")));
        //Test if the browser is on the correct page and stop the execution in case it is not.
        Assert.assertEquals("http://www.marosbike.ro/mtb-29er/", chrome.getCurrentUrl());
        chrome.findElement(By.xpath("//*[@id=\"available_filters\"]/li/a[contains(., 'Devron')]")).click();

        //  Wait for newsletter popup and close it in case it appears.
        letterWait("//*[@id='nl-headbar-close']");

    }

    @Test
    public void CheckIfResultsAreFiltered() {

        List<WebElement> results = chrome.findElements(By.xpath("//*[@id=\"content\"]/div/div/div[@class='productName']/a"));
        for (WebElement we : results) {
            Assert.assertTrue(we.getText().contains("Devron"));
        }

    }
}
