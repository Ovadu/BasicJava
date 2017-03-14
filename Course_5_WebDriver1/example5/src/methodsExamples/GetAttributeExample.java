package methodsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		String attr = driver.findElement(By.id("lst-ib")).getAttribute("class");
		
		//this will print "gsfi lst-d-f"
		System.out.println("The class name is: " + attr);
	}

}
