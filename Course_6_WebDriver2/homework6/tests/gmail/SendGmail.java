package gmail;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
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

        System.out.println("openChrome - Successful");
    }

    static void closeDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();

        System.out.println("closeDriver - Successful");
    }

    static void loginGmail(String user, String passwd) {
        driver.get("https://mail.google.com");

        fillUser(user);
        fillPassword(passwd);

        System.out.println("loginGmail - Successful");
    }

    static void fillUser(String user) {
        try {
            waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/input[@id='Email']")));
            driver.findElement(By.xpath("//*/input[@id='Email']")).clear();
            driver.findElement(By.xpath("//*/input[@id='Email']")).sendKeys(user);
            driver.findElement(By.xpath("//*/input[@id='next']")).click();

        } catch (Throwable t) {
            t.printStackTrace();
        }

        System.out.println("fillUser - Successful");
    }

    static void fillPassword(String passwd) {
        try {
            waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/input[@id='Passwd']")));
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

        System.out.println("fillPassword - Successful");
    }

    static void logoutGmail() {
        String googleAccount = "//*/div[@role='banner']//*/a[contains(@title,'Cont Google:') or contains(@title,'Google Account:')]";
        String signOutButton = "//*/div[@role='banner']//*[text()='Deconectați-vă' or text()='Sign out']";

        waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(googleAccount)));

        waitElem.until(ExpectedConditions.attributeContains(By.xpath(googleAccount), "area-expanded", "true"));
        driver.findElement(By.xpath(signOutButton)).click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Throwable t) {

        }

        System.out.println("logoutGmail - Successful");
    }

    static void pressCompose() {
        String composeButton = "//*[@class='nM']//*/div[text()='COMPOSE' or text()='SCRIE']";

        waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(composeButton)));
        driver.findElement(By.xpath(composeButton)).click();

        System.out.println("pressCompose - Successful");
    }

    static void fillToBox(String recipients) {
        String toBoxClicked = "//*[@enctype='multipart/form-data']//*[@aria-label='To']";

        //Fill to box
        waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath(toBoxClicked)));
        new Actions(driver)
                .click(driver.findElement(By.xpath(toBoxClicked)))
                .sendKeys(recipients)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        System.out.println("fillToBox - Successful");
    }

    static void fillSubject(String subject) {
        String subjectBox = "//*[@enctype='multipart/form-data']//*[@name='subjectbox' and @placeholder='Subiect' or @placeholder='Subject']";

        waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath(subjectBox)));
        new Actions(driver)
                .click(driver.findElement(By.xpath(subjectBox)))
                .sendKeys(subject)
                .build()
                .perform();

        System.out.println("fillSubject - Successful");
    }

    static void changeFont() {
        String formatButton = "//*/table//*[contains(@data-tooltip, 'formatare') or contains(@data-tooltip, 'Formatting')]//*[@role='button']";
        String fontOption = "//*/table//*[contains(@data-tooltip,'Font ')]";

        waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formatButton)));

        if (driver.findElement(By.xpath(formatButton)).getAttribute("aria-expanded").equalsIgnoreCase("false")) {

            new Actions(driver)
                    .click(driver.findElement(By.xpath(formatButton)))
                    .build()
                    .perform();
        }

        waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fontOption)));
        new Actions(driver)
                .click(driver.findElement(By.xpath(fontOption)))
                .click(driver.findElement(By.xpath("//*[contains(text(),'Comic Sans')]")))
                .build()
                .perform();

        System.out.println("changeFont - Successful");
    }

    static void fillEmail(String body) {
        String messageBody = "//*[@aria-label='Corpul mesajului' or @aria-label='Message Body']";

        waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(messageBody)));
        new Actions(driver).moveToElement(driver.findElement(By.xpath(messageBody)))
                .sendKeys(body)
                .build()
                .perform();
    }

    static void sendEmail() {
        String sendButton = "//*[@role='button' and contains(@aria-label, 'Trimite') or contains(@aria-label, 'Send')]";

        new Actions(driver)
                .moveToElement(driver.findElement(By.xpath(sendButton)))
                .click()
                .build()
                .perform();
    }

    static void takeScreenShot(String ssPath) {
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrShot, new File(ssPath));
        } catch (IOException e) {}
    }
    
    static void uploadFile(String filePath){
        String attachButton = "//*[@aria-label='Attach files' and @role='button']";

        waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(attachButton)));
        driver.findElement(By.xpath(attachButton)).click();

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(filePath), null);

        try{
            Robot robot = new Robot();
            robot.delay(2000);
            //robot.keyPress(KeyEvent.VK_ENTER);
            //robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        }catch(AWTException e){}


    }
    

//    static boolean refreshInbox() {
//        String inboxButton = "///*a[contains(@href, 'mail.google.com') and contains(@aria-label, 'Inbox')]";
//        String firstID;
//        String secondID;
//
//
//        firstID = driver.findElement(By.xpath("///*a[contains(@href, 'mail.google.com') and contains(@aria-label, 'Inbox')]")).getAttribute("aria-label");
//
//        boolean ref = false;
//
//        while (!ref) {
//            waitElem.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath(inboxButton)),))));
//            driver.findElement(By.xpath(inboxButton)).click();
//            secondID = driver.findElement(By.xpath("///*a[contains(@href, 'mail.google.com') and contains(@aria-label, 'Inbox')]")).getAttribute("aria-label");
//            if (firstID.equalsIgnoreCase(secondID)) {
//                ref = true;
//            }
//        }
//        return ref;
//    }

    static void openLatestEmail() {
        String latestEmail = "//*[@gh='tl']//*[@role='tabpanel']//*/tbody/tr[1]";

        waitElem.until(ExpectedConditions.presenceOfElementLocated(By.xpath(latestEmail)));
        new Actions(driver)
                .click(driver.findElement(By.xpath(latestEmail)))
                .build()
                .perform();
    }

    static void moveToTrash() {
        String moveToButton = "//*[@aria-label='Move to']";

        new Actions(driver).moveToElement(driver.findElement(By.xpath(moveToButton)))
                .click()
                .build()
                .perform();
    }


    private static String calcFontSizes() {
        String fontSizeButton = "//*[@role='toolbar' and contains(@aria-label, 'Formatting')]//*[contains(@aria-label, 'Size')]";
        String fontSizePopup = "//*[@class='J-M J-M-ayU fx']";


        waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fontSizeButton)));
        driver.findElement(By.xpath(fontSizeButton)).click();

        waitElem.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fontSizePopup)));
        WebElement fontSizeList = driver.findElement(By.xpath(fontSizePopup));
        String fontSizes = (((JavascriptExecutor)driver).executeScript("return arguments[0].children.length;", driver.findElement(By.xpath(fontSizePopup)))).toString();

        return fontSizes;
    }


    public static void main(String[] args) {
//      ---------------------------------------------------------------------------------------------------
//      Enter your name in the boxes below:
//      ---------------------------------------------------------------------------------------------------
        String fName = "Ovidiu";
        String lName = "Luchian";
//      ---------------------------------------------------------------------------------------------------
//      Enter your email credentials below:
//      ---------------------------------------------------------------------------------------------------
        String user = "web.driver.hw6.ovi";
        String pass = "Homework6";

        String subject = String.format("Date %s. Testing & finding BUGS! %s %s", date, fName, lName);
        String screenShotPath = String.format("C:\\Users\\%s\\Desktop\\SS\\screenshot_webdriver.jpg", String.join(".", fName.toLowerCase(), lName.toLowerCase()));

        openChrome();
        loginGmail(user, pass);
        pressCompose();

        fillToBox(user + "@gmail.com");
        fillSubject(subject);
        changeFont();

        takeScreenShot(screenShotPath);
        uploadFile(screenShotPath);


        fillEmail(calcFontSizes());
//        sendEmail();

//        refreshInbox();
//        openLatestEmail();

//        moveToTrash(); /*NOT WORKING YET :)*/

//        logoutGmail();
//        closeDriver();
    }

}