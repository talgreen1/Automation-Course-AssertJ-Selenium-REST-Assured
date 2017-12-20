package selenium._14_bychained_byall;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * https://www.codesd.com/item/how-does-the-bychained-class-of-selenium-really-work.html
 */
public class ByAllExample {
    private static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        createRemoteWebDriver();

        String URI = "file:///" + System.getProperty("user.dir") + "/src/main/java/selenium/_14_bychained_byall/index.html";
        driver.get(URI);

        By byAll = new ByAll(By.id("address_id"), By.name("wrong name"), By.className("wrong class name"));
        driver.findElement(byAll).sendKeys("- Test ByAll Using ID - ");

        byAll = new ByAll(By.id("Wrong ID"), By.name("address_name"), By.className("wrong class name"));
        driver.findElement(byAll).sendKeys(" - Test ByAll Using name - ");
    }

    private static void createRemoteWebDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());


    }
}
