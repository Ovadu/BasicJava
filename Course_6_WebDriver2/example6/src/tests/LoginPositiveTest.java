package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class LoginPositiveTest {

	public static WebDriver driver = new ChromeDriver();
	public static WebDriverWait waitName = new WebDriverWait (driver, 10);
	
	@BeforeClass
	public static void setup() {	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://mail.yahoo.com");
		waitName.until(ExpectedConditions.titleContains("Yahoo"));
		driver.findElement(By.id("login-username")).sendKeys("nsr.wd11");
		driver.findElement(By.id("login-signin")).click();
		waitName.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));
		driver.findElement(By.id("login-passwd")).sendKeys("QWerty1234!@");
		driver.findElement(By.id("login-signin")).submit();
		waitName.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#yucs-top-mail a")));
		driver.findElement(By.cssSelector("#yucs-top-mail a")).click();
		waitName.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Compose button")));
	}
	
	@AfterClass
	public static void after (){
		driver.quit();
	}
	
	@Test
	public void testInboxElement(){
		boolean inboxIsDisplayed = driver.findElement(By.id("Inbox")).isDisplayed();
		assertTrue (inboxIsDisplayed);
	}
	
	@Test
	public void testHomeElement(){
		boolean nameIsDisplayed = driver.findElement(By.id("yucs-home_link")).isDisplayed();
		assertTrue (nameIsDisplayed);
	} //..more test methods
}
