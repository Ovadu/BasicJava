package methodsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("My Company Name");
		driver.findElement(By.xpath("//input[@value='Submit']")).submit();

	}

	/*.click() method :
 	You can use .click() method to click on any button.There is no restriction for click buttons.
 	That means element's type = "button" or type = "submit", .click() method will works for both.
 	If button is inside <form> tag or button is outside <form> tag, the click() method will work.

	.submit() method :
	we can use .submit() method for only submit form after click on button.
	That means element's type = "submit" and button should be inside <form> tag, then only submit() will work.
	If element's type = "button" means submit() will not work.
	If button outside of the <form> tag means submit() will not work


	For example, submit() will work if submit button should be inside <form> tag and element type="submit" as below

	<form>
		<input id="submitbutton" name="submitbutton" type="submit" value="Next step" class="g-button g-button-submit">
	</form>

	But click() method will work for all  buttons in webpage without any restrictions.
	*/
}
