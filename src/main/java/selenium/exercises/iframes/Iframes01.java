package selenium.exercises.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Iframes01 {

    public static void main(String[] args) {
        WebDriver driver = createFirefoxDriver();

        driver.get("http://toolsqa.com/iframe-practice-page/");

        driver.switchTo().frame("IF2");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div[1]/h5")).getText());
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        driver.findElement(By.id("ui-id-3")).click();

        driver.findElement(By.name("txt1")).getText();





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
