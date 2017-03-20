package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {

	public static WebDriver driver = new ChromeDriver();
	public static WebDriverWait waitName = new WebDriverWait (driver, 10);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver.manage().window().maximize();
		
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement source = driver.findElement((By.id("draggable")));
		WebElement target = driver.findElement(By.id("droppable"));
		
		new Actions(driver).dragAndDrop(source, target).perform();
		
	}

}
