package selenium._14_bychained;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * https://www.codesd.com/item/how-does-the-bychained-class-of-selenium-really-work.html
 */
public class App {
    private static WebDriver driver;
    public static void main(String[] args) throws MalformedURLException {
        createRemoteWebDriver();

        String URI = "file:///" + System.getProperty("user.dir") + "/src/main/java/selenium/_14_bychained/index.html";
        driver.get(URI);
        By myBy = new ByChained(By.id("details2"),By.id("firstName"));

        driver.findElement(myBy).sendKeys("test");
    }

    private static void createRemoteWebDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());


    }
}
