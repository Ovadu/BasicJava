package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorGoogle {

	public static WebDriver driver = new ChromeDriver();
	static WebDriverWait waitName = new WebDriverWait (driver, 10);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 driver.get("https://www.google.ro/");
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 driver.findElement(By.id("lst-ib")).sendKeys("selenium webdriver");
		 
		 ((JavascriptExecutor)driver).executeScript("document.getElementById('lst-ib').blur()");
		 
		 //((JavascriptExecutor)driver).executeScript("document.getElementById('lst-ib').focus()");
		 
		//blur() - Removes focus from an element
		//focus() - Gives focus to an element

	}

}
