package methodsExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driverName = new ChromeDriver();
		
		driverName.get("http://google.com");
		
		driverName.get("http://www.toolsqa.com");
		
		driverName.navigate().back();
		
	}

}
