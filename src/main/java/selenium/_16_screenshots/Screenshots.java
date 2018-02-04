package selenium._16_screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Screenshots {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException {
        createRemoteWebDriver();

        driver.get("http://www.google.com");

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("c:\\temp\\screenshot.png"));


    }

    private static void createRemoteWebDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.firefox());

        driver.get("http://www.google.com");
    }
}
