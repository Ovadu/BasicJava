import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by ovidiu.luchian on 17-Mar-17.
 *
 * Warning!!! Right click is not working in all frames of the webpages.
 */

public class OpenPage {
    static WebDriver chrome = new ChromeDriver();

    /*The desired emulator page is accessible*/
    @BeforeClass
    public static void precondtitions() {
        chrome.get("chrome://newtab");
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chrome.navigate().to("http://www.tp-link.ro");

//        String emulatorsPage = chrome.getWindowHandle();
//        chrome.findElement(By.xpath("//*[@id='list']/div/div/span/a[@data-model[contains(., 'TL-WR841ND')]]")).click();
//        chrome.findElement(By.xpath("//*[@id='list']/table/tbody/tr/td/div/a[@href[contains(.,'TL-WR841ND_v9')]]")).click();
//        String routerSetup = chrome.getWindowHandle();
//        chrome.switchTo().window(emulatorsPage).close();
//        chrome.switchTo().window(routerSetup);
    }

    @Test
    public void OpenThePage(){

    }


//    @AfterClass
//    public static void driverClose() {
//        chrome.quit();
//    }
}
