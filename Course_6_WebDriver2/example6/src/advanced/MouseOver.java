package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseOver {

	public static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) {

		driver.manage().window().maximize();
		
		driver.get("http://store.demoqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
		//simulate a mouse move over the "Product Category" link on the top menu
		//use perform() action on the main menu to hold the menu list till the time Selenium identify the sub menu item and click on it
        new Actions(driver).moveToElement(driver.findElement(By.linkText("Product Category"))).perform();
 
        //select the "iPads" item from the drop down menu
        driver.findElement(By.linkText("iPads")).click();
	}

}
