package methodsExamples;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetLocationAndSizeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		Point loc = driver.findElement(By.id("lst-ib")).getLocation();
		Dimension size = driver.findElement(By.name("btnK")).getSize();
		
		//this will print something like "281 324"
		System.out.println(loc.x + " " + loc.y);
		
		//this will print something like "36 130"
		System.out.println(size.height + " " + size.width);
	}

}
