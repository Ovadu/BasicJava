package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RightClick {
	
	public static WebDriver driver = new ChromeDriver();
	static WebDriverWait waitName = new WebDriverWait (driver, 10);
	
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		
		 driver.get("https://www.google.ro/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 driver.findElement(By.id("lst-ib")).sendKeys("selenium webdriver");
		 driver.findElement(By.name("btnG")).click();
		 
		 waitName.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("selenium")));
		 
		 //right click on the first link and press the "t" key to open that link in a new tab - works only on Firefox
		 /*new Actions(driver).contextClick(driver.findElement(By.cssSelector("#rso .r a")))
				 .sendKeys("t")
				 .perform();*/
		 
		 new Actions(driver).contextClick(driver.findElement(By.cssSelector("#rso .r a")))
		 	.build().perform();
	}

}
