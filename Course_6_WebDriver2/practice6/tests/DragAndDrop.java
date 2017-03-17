import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by ovidiu.luchian on 16-Mar-17.
 */
public class DragAndDrop {
    static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void preconditions() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");

        WebElement src = driver.findElement(By.xpath("//*[@id=\'draggable\']"));
        WebElement targ = driver.findElement(By.xpath("//*[@id=\'droppable\']"));

        new Actions(driver).dragAndDrop(src, targ).perform();
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }

    @Test
    public void dropped() {
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[@id='droppable']/p")).getText());
    }
}
