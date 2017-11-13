package selenium._06_select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo {

    public static void main(String[] args) {
        WebDriver driver = createFirefoxDriver();

        driver.get("http://toolsqa.com/automation-practice-form/");

        WebElement continents = driver.findElement(By.id("continents"));
        Select select = new Select(continents);
        select.selectByVisibleText("Australia");
        select.selectByIndex(2);


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
