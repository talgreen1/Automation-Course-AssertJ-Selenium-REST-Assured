package selenium.exercises.saveimage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class SaveImage {

    private static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException, AWTException, InterruptedException {

        createRemoteWebDriver();

        driver.get("http://www.ebay.com");

        // Locate the image
        WebElement logo = driver.findElement(By.id("gh-logo"));

        // Right click on the image using contextClick method
        Actions actions = new Actions(driver);
        actions.moveToElement(logo).moveByOffset(-10, -10).contextClick().build().perform();

        // Create a Robot instance in order to send keys outside the browser
        Robot robot = new Robot();

        //perfrom perssing on 'v' key - save image as
        robot.keyPress(KeyEvent.VK_V);

        // Code to type c:\temp\ & enter

        Thread.sleep(3000);

        // To press home key
        robot.keyPress(KeyEvent.VK_HOME);
        // To press C key.
        robot.keyPress(KeyEvent.VK_C);
        // To press : key.
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_SEMICOLON);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        // To press \ key.
        robot.keyPress(KeyEvent.VK_BACK_SLASH);
        // To press "test" key one by one.
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_BACK_SLASH);
        // To press Save button.
        robot.keyPress(KeyEvent.VK_ENTER);



    }


    private static void createRemoteWebDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());


    }
}
