/*
Example:

1. Define  a Firefox driver.
2. Enter  the Google site.
3. Type �webdriver selenium� in the google search field.
4. Wait for the page to load, with a timeout of 10 seconds.
5. Verify if  the page title is correct and write to the console �Incorrect page� if you are in the wrong page, otherwise write the page�s title.
6. Close driver.
 */

package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
1. Define a Firefox driver.
2. Enter the Google site.
3. Type “webdriver selenium” in the google search field.
4. Wait for the page to load, with a timeout of 10 seconds.
5. Verify if the page title is correct and write to the console “Incorrect page” if you are in the wrong page, otherwise write the page’s title.
6. Close driver.
*/

public class PracticalExampleWait {

public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://google.com");
	driver.findElement(By.id("lst-ib")).sendKeys("selenium webdriver");
	
	driver.findElement(By.name("btnG")).click();
	
	WebDriverWait wait = new WebDriverWait (driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Selenium WebDriver")));
	
	if(driver.getTitle().matches("selenium webdriver - .*"))
	{
		System.out.println(driver.getTitle());
	}else
	{
		System.out.println("Incorrect page");
	}
	
	driver.close();
}
}
