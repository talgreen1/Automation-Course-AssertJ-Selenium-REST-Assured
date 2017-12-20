package selenium._15_page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class PageFactoryUsingNames {

    static WebDriver driver;

    // In order to use the PageFactory, first declare some fields on a PageObject that are WebElements

    static WebElement firstName;
    static WebElement lastName;

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String URI = "file:///" + System.getProperty("user.dir") + "/src/main/java/selenium/_15_page_factory/index.html";
        driver.get(URI);

        // In order for this code to work and not throw a NullPointerException because

        // the "log", "pwd" nd "submit" fields aren't instantiated, we need to initialise the PageObject

        PageFactory.initElements(driver, PageFactoryUsingNames.class);

        // Once Instantiated, we can now use the above created WebElements

        firstName.sendKeys("Gidi");

        lastName.sendKeys("Gov");

//        driver.quit();
    }
}
