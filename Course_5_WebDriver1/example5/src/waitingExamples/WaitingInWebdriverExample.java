package waitingExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingInWebdriverExample {
	
	public static void main(String[] args) {
		
		WebDriver driverName = new ChromeDriver ();
		driverName.get("http://google.ro");
		
		//implicit waits
		driverName.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//explicit waits (wait until "Google search" button it is present on page)
		//V1
		WebDriverWait breakName = new WebDriverWait (driverName, 25);
		breakName.until(ExpectedConditions.presenceOfElementLocated(By.name("btnK")));
		
		//V2
		new WebDriverWait (driverName, 25).until(new ExpectedCondition<Boolean>(){
			public Boolean apply (WebDriver d){
				return d.findElement(By.name("btnK")).isDisplayed();
			}
		});
		
		//V3
		new WebDriverWait(driverName, 25)
				.until(new ExpectedCondition<WebElement>(){
					public WebElement apply (WebDriver e){
						return e.findElement(By.name("btnK"));
					}
				});
	}
}
