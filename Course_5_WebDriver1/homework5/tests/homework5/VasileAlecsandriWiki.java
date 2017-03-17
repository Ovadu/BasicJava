package homework5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by ovidiu.luchian on 10-Mar-17.
 */
public class VasileAlecsandriWiki {
    static WebDriver chrome = new ChromeDriver();
    static WebDriverWait waitTenSec = new WebDriverWait(chrome, 10);

/*Open Google Chrome
* Set implicit wait
* Search for Vasile Alecsandri wiki on google
* Wait for search results (max 10 seconds)
* Open Wiki page*/

    @BeforeClass
    public static void precondition() {
        chrome.get("https://www.google.com");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chrome.manage().window().maximize();

        chrome.findElement(By.cssSelector("#lst-ib")).clear();
        chrome.findElement(By.cssSelector("#lst-ib")).sendKeys("Vasile Alecsandri wiki");
        chrome.findElement(By.cssSelector("#_fZl")).click();

        waitTenSec.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href*='wikipedia.org/wiki/Vasile_Alecsandri']")));
        chrome.findElement(By.xpath("//*[@id='rso']/div/div/div/div/h3/a[@href[contains(., 'ro.wikipedia.org')]]")).click();
//        waitTenSec.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#firstHeading^='Vasile Alecsandri']")));
    }

//    Close tab and quit Chrome Driver
    @AfterClass
    public static void closeDrivers() {
        chrome.close();
        chrome.quit();
    }

//    Check if Vasile Alecsandri's name appears in the article's header
    @Test
    public void searchForVasile() {
        String articleName = chrome.findElement(By.id("firstHeading")).getText();
        Assert.assertEquals("Vasile Alecsandri", articleName);
    }

//    Check if signature picture is displayed
    @Test
    public void checkForSignature() {
        Assert.assertTrue(chrome.findElement(By.xpath("//*[@id=\'mw-content-text\']/table[3]/tbody/tr[14]/td/a/img")).isDisplayed());
    }

//    Check portrait size
    @Test
    public void checkPortraitSize() {
        Assert.assertEquals(new Dimension(150, 215), chrome.findElement(By.xpath("//*[@id=\'mw-content-text\']/table[3]/tbody/tr[2]/td/a/img")).getSize());
    }
}
