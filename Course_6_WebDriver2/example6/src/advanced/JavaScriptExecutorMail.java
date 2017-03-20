package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorMail {
	

	public static WebDriver driver;
	public static WebDriverWait waitName;
	
	public static void login()
	{
		driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.get("http://www.google.ro/");
				
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//explicit wait
		waitName = new WebDriverWait(driver, 30);
		waitName.until(ExpectedConditions.visibilityOfElementLocated(By.id("hplogo")));
		
		WebElement search = driver.findElement(By.id("lst-ib"));
		search.clear();
		search.sendKeys("yahoo mail");
		
		driver.findElement(By.name("btnG")).click();
		
		driver.findElement(By.partialLinkText("Yahoo - login")).click();
		
		waitName.until(ExpectedConditions.titleContains("Yahoo"));
		
		WebElement username = driver.findElement(By.id("login-username"));
		username.clear();
		username.sendKeys("nsr.wd11");
		
		driver.findElement(By.id("login-signin")).click();
		
		waitName.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));
		WebElement password = driver.findElement(By.id("login-passwd"));
		password.clear();
		password.sendKeys("QWerty1234!@");
		
		driver.findElement(By.id("login-signin")).click();
		
		waitName.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#yucs-top-mail a")));
		driver.findElement(By.cssSelector("#yucs-top-mail a")).click();
		
		waitName.until(ExpectedConditions.visibilityOfElementLocated(By.id("Inbox"))); //Inbox tab
	}
	
	public static void composeMessage(){
		driver.findElement(By.cssSelector("#Compose button")).click();
		waitName.until(ExpectedConditions.visibilityOfElementLocated(By.id("to-field")));
		driver.findElement(By.id("to-field")).sendKeys("nsr21140@yahoo.com");
		
		((JavascriptExecutor)driver).executeScript("document.getElementById('to-field').blur()");
		//blur() - Removes focus from an element
		//focus() - Gives focus to an element
	}
	
	public static void main(String[] args){
		login();	
		composeMessage();
		//driver.close();
	}

}
