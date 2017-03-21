package gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ovidiu.luchian on 21-Mar-17.
 */
public class SendGmail {
    static WebDriver chrome = new ChromeDriver();


    static void loginGmail(String user, String pass) {

        //If correct user is in the email display element, insert password.
        if (chrome.findElement(By.xpath("//*[@id='email-display']")).getText().contains(user)) {
            try {
                chrome.findElement(By.xpath("//*/input[@id='Passwd']")).clear();
                chrome.findElement(By.xpath("//*/input[@id='Passwd']")).sendKeys(pass);
                chrome.findElement(By.xpath("//*/input[@id='signIn']"));
                //Uncheck "Remember Me" checkbox.
                if (chrome.findElement(By.xpath("//*[@id='PersistentCookie']")).isSelected()) {
                    chrome.findElement(By.xpath("//*[@id='PersistentCookie']")).click();
                }


                System.out.println("The Password input box was found and filled");

            } catch (Throwable t) {
                System.out.println(t.getMessage());
            }
            //If no user is entered in the email display element, type user.
        } else {

            try {
                chrome.findElement(By.xpath("//*/input[@id='Email']")).clear();
                chrome.findElement(By.xpath("//*/input[@id='Email']")).sendKeys(user);
                chrome.findElement(By.xpath("//*/input[@id='next']")).click();

                System.out.println("The Username input box was found and filled");

            } catch (Throwable t) {
                System.out.println(t.getMessage());

            }
        }

    }

    static void openChrome(){
        chrome.get("https://mail.google.com");
        chrome.manage().window().maximize();

    }

    static void closeDriver() {
        chrome.manage().deleteAllCookies();
        chrome.quit();
    }

    public static void main(String[] args) {
        openChrome();
        loginGmail("web.driver.hw6.ovi", "Homework6");
        closeDriver();
    }
}
