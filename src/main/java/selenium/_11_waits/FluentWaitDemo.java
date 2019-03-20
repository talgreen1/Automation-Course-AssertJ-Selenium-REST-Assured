package selenium._11_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.function.Function;

@SuppressWarnings("Duplicates")
public class FluentWaitDemo {

    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());

        driver.get("http://www.ebay.com");


        Wait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        wait.until(
                new Function<WebDriver, Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return driver.findElement(By.id("gh-ac1")).getAttribute("value").equals("ddd");
                    }
                }
        );


    }


}
