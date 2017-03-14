import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ovidiu.luchian on 09-Mar-17.
 */
public class ClickExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
    WebElement searchBox = driver.findElement(By.id("lst-ib"));
    WebElement searchButton = driver.findElement(By.cssSelector(".jsb > center > input"));
    WebElement searchLuckyButton = driver.findElement(By.xpath("//div[@class='jsb']/center/input[@name='btnI']"));
    WebElement searchContextual = driver.findElement(By.name("btnG"));

        searchBox.sendKeys("selenium webdriver");
        searchContextual.click();
}
}
