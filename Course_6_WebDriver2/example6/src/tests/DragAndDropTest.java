package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//Define a Chrome driver
//Enter the http://jqueryui.com/resources/demos/droppable/default.html site
//Maximize the window
//Make the "drag and drop" action
//Make a test to verify if the "Dropped!" text is present
//Close the driver

public class DragAndDropTest {
	

	public static WebDriver driver = new ChromeDriver();
	
	@BeforeClass
	public static void setup() {	

		driver.manage().window().maximize();
		
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement source = driver.findElement((By.id("draggable")));
		WebElement target = driver.findElement(By.id("droppable"));
		
		new Actions(driver).dragAndDrop(source, target).perform();
	}
	
	@AfterClass
	public static void after (){
		driver.quit();
	}
	
	@Test
	public void test(){
		String actualText = driver.findElement(By.cssSelector("#droppable>p")).getText();
		Assert.assertEquals("Dropped!", actualText);
	}
}