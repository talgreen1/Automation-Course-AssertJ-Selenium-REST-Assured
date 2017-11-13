package selenium._02_driver_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverCommands {
    public static void main(String[] args) {
        WebDriver driver = createFirefoxDriver();

        driver.get("http://www.ebay.com");
        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("http://www.yahoo.com");

        driver.navigate().back();

        driver.quit();

    }


    private static WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver","c:/temp/selenium/drivers/geckodriver.exe");

        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver","c:/temp/selenium/drivers/chromedriver.exe");

        return new ChromeDriver();
    }

}
