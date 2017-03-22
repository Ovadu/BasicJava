package gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by ovidiu.luchian on 21-Mar-17.
 */

public class SendGmail {
    static WebDriver driver;
    static WebDriverWait waitElem;
    static String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());


    static void openChrome() {
        driver = new ChromeDriver();
        waitElem = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    static void closeDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    static void loginGmail(String user, String passwd) {
        driver.get("https://mail.google.com");

        if (ExpectedConditions.presenceOfElementLocated(By.id("Email")) != null) {
            //If correct user is in the email display element, insert password.
            fillUser(user);
            waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/input[@id='Passwd']")));
            fillPassword(passwd);
        } else if (ExpectedConditions.presenceOfElementLocated(By.id("Passwd")) != null) {
            //If no user is entered in the email display element, type user.
            fillPassword(passwd);
        }

    }

    static void fillUser(String user) {
        try {
            driver.findElement(By.xpath("//*/input[@id='Email']")).clear();
            driver.findElement(By.xpath("//*/input[@id='Email']")).sendKeys(user);
            driver.findElement(By.xpath("//*/input[@id='next']")).click();

        } catch (Throwable t) {
            t.printStackTrace();
        }


    }

    static void fillPassword(String passwd) {
        try {
            driver.findElement(By.xpath("//*/input[@id='Passwd']")).clear();
            driver.findElement(By.xpath("//*/input[@id='Passwd']")).sendKeys(passwd);
            if (driver.findElement(By.xpath("//*/input[@id='PersistentCookie']")).isSelected()) {
                //Uncheck "Remember Me" check;box.
                driver.findElement(By.xpath("//*/input[@id='PersistentCookie']")).click();
            }
            driver.findElement(By.xpath("//*/input[@id='signIn']")).click();

        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    static void logoutGmail() {
        waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/div[@role='banner']")));
        driver.findElement(By.xpath("//*/div[@role='banner']//*/a[contains(@title,'Cont Google:') or contains(@title,'Google Account:')]")).click();
        waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//*/div[@role='banner']//*/a[contains(@title,'Cont Google:') or contains(@title,'Google Account:') and area-expanded='true']")));
        driver.findElement(By.xpath("//*/div[@role='banner']//*[text()='Deconectați-vă' or text()='Sign out']")).click();

    }

    static void pressCompose() {
        waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='nM']//*/div[text()='COMPOSE' or text()='SCRIE']")));
        driver.findElement(By.xpath("//*[@class='nM']//*/div[text()='COMPOSE' or text()='SCRIE']")).click();
    }

    static void fillToBox(String recipients) {
        waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/table//*[text()='Destinatari' or text()='Recipients']")));
        driver.findElement(By.xpath("//*[contains(@class, 'wO nr')]")).click();
        waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='wO nr l1']")));

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@class='wO nr l1']")))
                .click()
                .sendKeys(recipients)
                .build()
                .perform();
    }

    static void fillSubject(String subject){
        waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/table//*[@name='subjectbox' and @placeholder='Subiect' or @placeholder='Subject']")));

        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath("//*/table//*[@name='subjectbox' and @placeholder='Subiect' or @placeholder='Subject']")))
                .click()
                .sendKeys(subject)
                .build()
                .perform();
    }

    static void changeFont(){

        waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/table//*[contains(@data-tooltip, 'formatare') or contains(@data-tooltip, 'formatting')]/div[@role='button']")));

        if (driver.findElement(By.xpath("//*/table//*[contains(@data-tooltip, 'formatare') or contains(@data-tooltip, 'formatting')]/div[@role='button']"))
                .getAttribute("aria-expanded").equalsIgnoreCase("true")){
            waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/table//*[contains(@data-tooltip,'Font ')]")));

            new Actions(driver)
                    .moveToElement(driver.findElement(By.xpath("//*[contains(@data-tooltip,'Font ')]")))
                    .click()
                    .moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Comic Sans MS')]")))
                    .click()
                    .build()
                    .perform();

        } else if (driver.findElement(By.xpath("//*/table//*[contains(@data-tooltip, 'formatare') or contains(@data-tooltip, 'formatting')]/div[@role='button']"))
                .getAttribute("aria-expanded").equalsIgnoreCase("true")){

            new Actions(driver)
                    .moveToElement(driver.findElement(By.xpath("//*/table//*[contains(@data-tooltip, 'formatare') or contains(@data-tooltip, 'formatting')]/div[@role='button']")))
                    .click()
                    .build()
                    .perform();

            waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/table//*[contains(@data-tooltip,'Font ')]")));

            new Actions(driver)
                    .moveToElement(driver.findElement(By.xpath("//*[contains(@data-tooltip,'Font ')]")))
                    .click()
                    .moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Comic Sans MS')]")))
                    .click()
                    .build()
                    .perform();
        }


    }

    static void fillEmail(String body){
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@aria-label='Corpul mesajului' or @aria-label='Message Body']")))
                .sendKeys(body)
                .build()
                .perform();
    }

    static void sendEmail(){

        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath("//*[@role='button' and contains(@aria-label, 'Trimite') or contains(@aria-label, 'Send')]")))
                .click()
                .build()
                .perform();
    }

    static void refresh(){

        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath("//*[@role='button' and contains(@aria-label, 'Actualizează') or contains(@aria-label, 'Refresh')]")))
                .click()
                .build()
                .perform();
    }

    static void


    public static void main(String[] args) {
        String user = "web.driver.hw6.ovi";
        String pass = "Homework6";
        String subject = String.format("Date %s. Testing & finding BUGS! Ovidiu Luchian", date );

        openChrome();
        loginGmail(user, pass);

        pressCompose();

        fillToBox(user + "@gmail.com");
        fillSubject( subject );
        changeFont();
        fillEmail("length is 4");
        sendEmail();



//        logoutGmail();
//        closeDriver();
    }
}