package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//open the google page
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		
		//find the search box by id
		WebElement element1 = driver.findElement(By.id("lst-ib"));
		
		//find the "Google Search" button by cssSelector
		WebElement element2 = driver.findElement(By.cssSelector(".jsb > center > input"));
		
		//find the "I'm Feeling Lucky" button by XPath
		WebElement element3 = driver.findElement(By.xpath("//div[@class='jsb']/center/input[2]"));
		//WebElement element31 = driver.findElement(By.xpath("//input[@value='I'm Feeling Lucky']"));
		
		//find the "Deutsch" link by linkText	
		WebElement element4 = driver.findElement(By.linkText("Deutsch"));
	}

}
