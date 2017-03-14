/*
Practice Exercise 1
1) Launch new Browser

2) Open URL �http://toolsqa.com/automation-practice-switch-windows/�

3) Get Window name (Use GetWindowHandle command)

4) Click on Button �New Message Window�, it will open a Pop Up Window

5) Get all the Windows name ( Use GetWindowHandles command)

6) Close the Pop Up Window (Use Switch Command to shift window)
*/

package switchExamples;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindowsExample {
	
	public static WebDriver driverName = new ChromeDriver ();

	
	public static void main(String[] args) {
		
		driverName.get("http://toolsqa.com/automation-practice-switch-windows/");
		
		// Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
		driverName.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Store and Print the name of the First window on the console
		String handle= driverName.getWindowHandle();
		//getWindowHandle() will get the handle of the page the webDriver is currently controlling. 
		//This handle is a unique identifier for the web page. 
		//This is different every time you open a page even if it is the same URL.
		System.out.println(handle);
		
		// Click on the Button "New Message Window" 
		driverName.findElement(By.xpath("//p[3]/button")).click();
		
        // Store and Print the name of all the windows open	              
        Set<String> handles = driverName.getWindowHandles(); //A Set is a Collection that cannot contain duplicate elements.
        System.out.println(handles);
               
        // Pass a window handle to the other window
        String window1 = (String) handles.toArray()[0];
        String window2 = (String) handles.toArray()[1];
 
        driverName.switchTo().window(window2);
       /* for (String handle1 : driverName.getWindowHandles()) {
        	System.out.println(handle1);
        	driverName.switchTo().window(handle1);

        }*/

        // Closing Pop Up window
        driverName.close(); //Close() - It is used to close the browser or page currently which is having the focus

        // Close Original window
        driverName.quit(); //It is used to shut down the web driver instance or destroy the web driver instance(Close all the windows)

	}
}
