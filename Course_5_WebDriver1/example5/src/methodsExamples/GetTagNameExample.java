package methodsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTagNameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		String tag = driver.findElement(By.id("lst-ib")).getTagName();
		
		//this will print "input"
		System.out.println("The tag name is: " + tag);
	}

}
