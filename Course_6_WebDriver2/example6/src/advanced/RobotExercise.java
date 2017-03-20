package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotExercise {
	
	public static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args){
		
		driver.manage().window().maximize();
		
		driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
		
		driver.findElement(By.cssSelector("input[type = 'file']")).click();
		
		//copy the filepath to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("C:\\Users\\anamaria.sadagurschi\\Desktop\\test_uploading.txt"), null);
	
		try{
			Robot robot = new Robot();
			robot.delay(2000);
			//robot.keyPress(KeyEvent.VK_ENTER);
			//robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(3000);
		}catch(AWTException e){}
	}
	

}
