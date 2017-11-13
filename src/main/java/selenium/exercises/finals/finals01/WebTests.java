package selenium.exercises.finals.finals01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium._08_code_modeling.Parameters;

public class WebTests {

    private WebDriver driver;

    public void init() {
        System.setProperty(Parameters.DRIVER_TYPE, Parameters.DRIVER_PATH);
        driver = new ChromeDriver();

    }


    public void runTests() {
        validLoginTest();
        invalidLoginTest();
    }

    public void teardown() {
        driver.quit();
    }

    private void validLoginTest(){
        driver.get(Parameters.LOGIN_PAGE_URL);

        driver.findElement(Elements.USERNAME_INPUT).sendKeys(Parameters.VALID_EMAIL);
        driver.findElement(Elements.PASSWORD_INPUT).sendKeys(Parameters.VALID_PASSWORD);

        driver.findElement(Elements.LOGIN_BUTTON).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(Elements.VALID_LOGIN_VERIFICATION_TEXT));
    }

    private void invalidLoginTest(){
        driver.get(Parameters.LOGIN_PAGE_URL);

        driver.findElement(Elements.USERNAME_INPUT).sendKeys(Parameters.INVALID_EMAIL);
        driver.findElement(Elements.PASSWORD_INPUT).sendKeys(Parameters.INVALID_PASSWORD);

        driver.findElement(Elements.LOGIN_BUTTON).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(Elements.INVALID_LOGIN_VERIFICATION_TEXT));
    }
}
