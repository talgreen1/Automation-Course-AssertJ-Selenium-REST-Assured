package selenium._03_finding_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindingElements {

    public static void main(String[] args) {
        WebDriver driver = createFirefoxDriver();

        driver.get("http://www.ebay.com");

        WebElement element = driver.findElement(By.id("gh-ac"));
        System.out.println(element);

        element = driver.findElement(By.name("_nkw"));
        System.out.println(element);

        element = driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        System.out.println(element);

        element = driver.findElement(By.xpath("//*[@id='gh-ac']"));
        System.out.println(element);

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
