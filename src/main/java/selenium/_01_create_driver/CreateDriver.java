package selenium._01_create_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CreateDriver {
    public static void main(String[] args) {
//        createFirefoxDriver();
//        createChromeDriver();
        createInternetExplorerDriver();
    }


    private static void createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver","c:/temp/selenium/drivers/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
    }

    private static void createChromeDriver() {
        System.setProperty("webdriver.chrome.driver","c:/temp/selenium/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }

    private static void createInternetExplorerDriver() {
        System.setProperty("webdriver.ie.driver","c:/temp/selenium/drivers/IEDriverServer.exe");

        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://www.google.com");
    }
}
