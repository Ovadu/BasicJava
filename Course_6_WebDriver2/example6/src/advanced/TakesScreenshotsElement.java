package advanced;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TakesScreenshotsElement {

	public static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 driver.get("http://docs.seleniumhq.org/projects/webdriver");
		 driver.manage().window().maximize();
		 
		 //take screenshot of a specific element
		 WebElement element = driver.findElement(By.id("header"));
		 
		 File scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 File f = new File("C:\\Users\\anamaria.sadagurschi\\Desktop\\screenshot_webdriver.jpg");
		 BufferedImage img = ImageIO.read(scrShot);
		 
		 Point p = element.getLocation();
		 int width = element.getSize().getWidth();
		 int height = element.getSize().getHeight();
		 BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width, height);
		 ImageIO.write(dest, "png", f);
		 
		 driver.close();
		 
		 //What this does is capture a screenshot, saves it to file. 
		 //Then, reads that file as an image and grabs a subimage based on the position 
		 //of the element.
	}
}
