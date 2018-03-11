package selenium._12_selenium_server;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class SeleniumServer {

    public static void main(String[] args) throws MalformedURLException {

        createRemoteWebDriver();
//        createRemoteWebDriverIncognito();

//        test();
    }

    private static void createRemoteWebDriver() throws MalformedURLException {
        WebDriver driver = new RemoteWebDriver(
//                new URL("http://localhost:4444/wd/hub"),
                new URL("http://192.168.99.100:4444/wd/hub"),
                DesiredCapabilities.chrome());

        driver.get("http://www.google.com");

    }

    private static void createRemoteWebDriverIncognito() throws MalformedURLException {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("incognito");

        capabilities.setCapability("chromeOptions", options);

        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                capabilities);

        driver.get("http://www.google.com");
    }

    private static void test() throws MalformedURLException {

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);

        DesiredCapabilities caps = DesiredCapabilities.firefox();

        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);


        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"), caps
        );

        driver.get("file:///C:/temp/demo%20site/Login.html");
        LogEntries browser = driver.manage().logs().get(LogType.BROWSER);



        System.out.println(browser.getAll());

    }
}
