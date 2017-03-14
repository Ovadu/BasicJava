package methodsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCssValueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		String css = driver.findElement(By.id("lst-ib")).getCssValue("width");
		
		//this will print "363px"
		System.out.println("The width is: " + css);
	}

}
