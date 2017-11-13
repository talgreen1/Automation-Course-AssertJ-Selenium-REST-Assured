package selenium._11_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    public static void main(String[] args) {
        WebDriver driver = createChromeDriver();


        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("http://www.ebay.com");
        //driver.findElement(By.id("INVALID_ID")).sendKeys("some text");


        WebDriverWait wait10Sec = new WebDriverWait(driver, 10); // Time is in seconds
        wait10Sec.until(ExpectedConditions.elementToBeClickable(By.id("SomeID")));
        wait10Sec.until(ExpectedConditions.urlContains("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));




    }

    private static WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "c:/temp/selenium/drivers/geckodriver.exe");

        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "c:/temp/selenium/drivers/chromedriver.exe");

        return new ChromeDriver();
    }
}
