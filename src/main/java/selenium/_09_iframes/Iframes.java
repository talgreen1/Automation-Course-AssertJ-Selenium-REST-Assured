package selenium._09_iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Iframes {

    public static void main(String[] args) {
        WebDriver driver = createFirefoxDriver();

        driver.get("http://toolsqa.com/iframe-practice-page/");

        driver.switchTo().frame("IF1");
        driver.findElement(By.name("firstname")).sendKeys("Yoni");

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        driver.findElement(By.id("ui-id-3")).click();


    }

    private static WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "c:/temp/selenium/drivers/geckodriver.exe");

        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "c:/temp/selenium/drivers/chromedriver.exe");

        return new ChromeDriver();
    }
}
