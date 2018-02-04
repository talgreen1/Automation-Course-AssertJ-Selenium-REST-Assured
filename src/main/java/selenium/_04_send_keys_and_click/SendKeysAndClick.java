package selenium._04_send_keys_and_click;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SendKeysAndClick {

    public static void main(String[] args) {
        WebDriver driver = createFirefoxDriver();

        driver.get("http://www.ebay.com");

        WebElement element = driver.findElement(By.id("gh-ac"));
        element.sendKeys("new book");

        element = driver.findElement(By.id("gh-btn"));
        element.click();

        String val = element.getAttribute("value");
        System.out.println("The button value is - " + val);

        // Same - with fluent syntax
        driver.get("http://www.ebay.com");

        driver.findElement(By.id("gh-ac")).sendKeys("new book");

        driver.findElement(By.id("gh-btn")).click();

    }

    private static WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver","C:\\temp\\Selenium\\Latest\\geckodriver.exe");

        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver","c:/temp/selenium/drivers/chromedriver.exe");

        return new ChromeDriver();
    }
}
