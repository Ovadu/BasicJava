package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadingFile {

	public static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver.manage().window().maximize();
		
		driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
		
		driver.findElement(By.cssSelector("input[type = 'file']")).sendKeys("C:\\Users\\anamaria.sadagurschi\\Desktop\\test_uploading.txt");
		
		//driver.close
	}

}
