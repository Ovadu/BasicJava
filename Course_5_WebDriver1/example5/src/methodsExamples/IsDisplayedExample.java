package methodsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayedExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		boolean isDisp = driver.findElement(By.id("lst-ib")).isDisplayed();
		
		//this will print "element is displayed"
		System.out.println(isDisp == true ? "element is displayed" : 
											"element is not displayed");
	}

}
