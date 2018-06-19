package selenium._11_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Waits {

    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("http://www.ebay.com");
        //driver.findElement(By.id("INVALID_ID")).sendKeys("some text");


        WebDriverWait wait10Sec = new WebDriverWait(driver, 10); // Time is in seconds


        wait10Sec.until(ExpectedConditions.elementToBeClickable(By.id("SomeID")));
        wait10Sec.until(ExpectedConditions.urlContains("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));

        wait10Sec.until(myElementIsFound(By.id("gh-ac1"))).sendKeys("Hello");

    }

    private static ExpectedCondition<WebElement> myElementIsFound(By by) {
        return new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }

            public String toString() {
                return "My element is found expected condition";
            }
        };
    }
}
