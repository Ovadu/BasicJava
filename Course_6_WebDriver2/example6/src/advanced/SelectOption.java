package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SelectOption {

	public static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-form/");

		//select "Australia" from Continents drop-down list
		new Select(driver.findElement(By.cssSelector("#continents"))).selectByIndex(3);

		//select "North America" from Continents drop-down list
		//new Select(driver.findElement(By.cssSelector("#continents"))).selectByVisibleText("North America");

		//driver.close();
	}

}
