package selenium._07_parameters_and_elements.without;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Without {

    public static void main(String[] args) {
        WebDriver driver = createFirefoxDriver();

        driver.get("http://toolsqa.com/automation-practice-form/");

        driver.findElement(By.id("exp-2")).click();

        driver.get("http://demoqa.com/registration/");

        WebElement element = driver.findElement(By.xpath("//input[@value='married']"));
        System.out.println("Married is selected =  " + element.isSelected());
        element.click();
        System.out.println("Married is selected =  " + element.isSelected());

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
