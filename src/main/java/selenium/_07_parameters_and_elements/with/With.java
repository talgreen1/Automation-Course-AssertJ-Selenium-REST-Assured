package selenium._07_parameters_and_elements.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static selenium._07_parameters_and_elements.with.Elements.*;
import static selenium._07_parameters_and_elements.with.Parameters.*;

public class With {

    public static void main(String[] args) {
        WebDriver driver = createFirefoxDriver();

        driver.get(PRACTICE_AUTOMATION_FORM_URL);

        driver.findElement(TWO_YEARS_EXPERIENCE_RADIO_BUTTON).click();

        driver.get(REGISTRATION_FORM_URL);

        WebElement element = driver.findElement(MARRIED_RADIO_BUTTON);
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
