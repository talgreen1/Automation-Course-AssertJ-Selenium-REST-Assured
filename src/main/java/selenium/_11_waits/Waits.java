package selenium._11_waits;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
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


        WebDriverWait wait10Sec = new WebDriverWait(driver, 50); // Time is in seconds
        wait10Sec.pollingEvery(Duration.ofSeconds(1));


//        wait10Sec.until(ExpectedConditions.elementToBeClickable(By.id("SomeID")));
//        wait10Sec.until(ExpectedConditions.urlContains("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
//
//        wait10Sec.until(myElementIsFound(By.id("gh-ac1"))).sendKeys("Hello");

        String textFound = wait10Sec.until(valueIsNotEmpty(By.id("gh-ac")));
        System.out.println(textFound);

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

    private static ExpectedCondition<String> valueIsNotEmpty(By by) {
        return new ExpectedCondition<String>() {
            @NullableDecl
            @Override
            public String apply(@NullableDecl WebDriver driver) {
                String elementText = driver.findElement(by).getAttribute("value");
                if (elementText != null && !elementText.trim().isEmpty()) {
                    return elementText;
                }
                return null;
            }
        };
    }
}
