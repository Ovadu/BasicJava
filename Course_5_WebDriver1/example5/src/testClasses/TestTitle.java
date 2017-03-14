/*
Example:

1. Define  a Firefox driver.
2. Enter  the Google site.
3. Type �webdriver selenium� in the google search field.
4. Wait for the page to load, with a timeout of 10 seconds.
5. Verify if  the page title is correct and write to the console �Incorrect page� if you are in the wrong page, otherwise write the page�s title.
6. Close driver.
 */

package testClasses;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTitle {
	static WebDriver driver = new ChromeDriver ();

	@BeforeClass
	public static void setup(){
		driver.get("http://google.ro");
		driver.findElement(By.id("lst-ib")).sendKeys("webdriver selenium");
		driver.findElement(By.name("btnG")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
				(By.id("slim_appbar")));
	}

	@Test
	public void test1()
	{
		String stringTitle = driver.getTitle();
		String expectedTitle = "webdriver selenium - .*";
		Assert.assertTrue (stringTitle.matches(expectedTitle));
	}

	@AfterClass
	public static void afterTest()
	{
		driver.close();
	}
}
