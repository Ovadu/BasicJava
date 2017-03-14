package methodsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsEnabledExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		boolean isEnab = driver.findElement(By.id("lst-ib")).isEnabled();
		
		//this will print "element is enabled"
		System.out.println(isEnab == true ? "element is enabled" : 
											"element is not enabled");
	}

}
