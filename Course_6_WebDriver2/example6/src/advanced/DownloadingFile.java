package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadingFile {

	public static void main (String[] args){
		
		FirefoxProfile firefoxProfile = new FirefoxProfile();

		//specifies the download directory
		firefoxProfile.setPreference("browser.download.dir","C:\\Downloads");
		
		//specifies what types of files to be downloaded automatically
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,"
						+ "application/vnd.ms-excel,image/png,image/jpeg,text/html,"
						+ "application/msword,application/xml");
		
		//skip the download panel of the browser
		firefoxProfile.setPreference("browser.download.pannel.shown", false);
		
		WebDriver driver = new FirefoxDriver(firefoxProfile);
		
		driver.manage().window().maximize();

		driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/");
		driver.findElement(By.linkText("smilechart.xls")).click();
		//driver.close();
		
	}


}
