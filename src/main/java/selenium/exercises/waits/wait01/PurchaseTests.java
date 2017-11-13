package selenium.exercises.waits.wait01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static selenium.exercises.waits.wait01.Elements.*;
import static selenium.exercises.waits.wait01.Parameters.*;

public class PurchaseTests {

    private WebDriver driver;

    private static WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "c:/temp/selenium/drivers/geckodriver.exe");

        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "c:/temp/selenium/drivers/chromedriver.exe");

        return new ChromeDriver();
    }

    public void init() {
        driver = createChromeDriver();
    }

    public void runTests() {
        validPurchaseTest();
    }

    private void validPurchaseTest() {
        openPage();
        typeTextAndVerify();
        clickPurchaseButton();
        validatePurchase();
    }

    private void validatePurchase() {
        // We cannot use this code - We must wait for the text to appear
        //assertThat(driver.findElement(PURCHASE_COMPLETE_LABEL).getText()).contains(PURCHASE_OK_TEXT);

        WebDriverWait wait10Sec = new WebDriverWait(driver, 10);
        WebElement element = driver.findElement(PURCHASE_COMPLETE_LABEL);
        wait10Sec.until(ExpectedConditions.textToBePresentInElement(element,PURCHASE_OK_TEXT ));
    }

    private void clickPurchaseButton() {
        driver.findElement(PURCHASE_BUTTON).click();
    }

    private void typeTextAndVerify() {
        driver.findElement(FULL_NAME_INPUT).sendKeys(FULL_NAME_VALUE + Keys.TAB);
        assertThat(driver.findElement(FULL_NAME_CHECK_LABEL).getText()).isEqualTo(CHECK_OK_TEXT);

        driver.findElement(CREDIT_CARD_INPUT).sendKeys(CREDIT_CARD_VALUE + Keys.TAB);
        assertThat(driver.findElement(CREDIT_CARD_CHECK_LABEL).getText()).isEqualTo(CHECK_OK_TEXT);

        driver.findElement(MONTH_INPUT).sendKeys(MONTH_VALUE + Keys.TAB);
        assertThat(driver.findElement(MONTH_CHECK_LABEL).getText()).isEqualTo(CHECK_OK_TEXT);

        driver.findElement(YEAR_INPUT).sendKeys(YEAR_VALUE + Keys.TAB);
        assertThat(driver.findElement(YEAR_CHECK_LABEL).getText()).isEqualTo(CHECK_OK_TEXT);
    }

    private void openPage() {
        driver.get(Parameters.URL);
    }

    public void teardown() {
        driver.quit();
    }
}
