package methodsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextExample {

	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
	
		driver.get("http://google.com");
		String text = driver.findElement(By.id("_eEe")).getText();
	
		//this will print "Google.ro oferit �n: magyar Deutsch English"
		System.out.println("The text is: " + "\"" + text + "\"");
	}
}
