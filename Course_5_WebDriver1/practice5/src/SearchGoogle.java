package methodsExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ovidiu.luchian on 09-Mar-17.
 */
public class SearchGoogle {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        driver.findElement(By.id("lst-ib")).sendKeys("selenium webdriver");
        driver.findElement(By.name("btnG")).click();
    }
}
