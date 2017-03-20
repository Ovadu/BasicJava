package advanced;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakesScreenshots {

	public static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 driver.get("http://docs.seleniumhq.org/projects/webdriver");
		 
		 File scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 try{
			 FileUtils.copyFile(scrShot, new File("C:\\Users\\anamaria.sadagurschi\\Desktop\\screenshot_webdriver.jpg"));
		 }catch(IOException e){}
		 
		 driver.close();
	}

}
