package selenium._10_windows_and_tabs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WindowsAndTabs {

    private static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException {

        createRemoteWebDriver();

        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandles());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ("window.open();");

        System.out.println(driver.getWindowHandles());

        for (String win : driver.getWindowHandles()){
            driver.switchTo().window(win);
        }

    }




    private static void createRemoteWebDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());


    }
}
