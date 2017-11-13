package selenium.exercises.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WindowsAndTabs {

    private static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException {

        createRemoteWebDriver();

        printHandles("When opening the page");
        driver.get("http://toolsqa.com/automation-practice-switch-windows/");




        // Click new browser button
        driver.findElement(By.id("button1")).click();
        printHandles("After opening new window");

        // Click new tab button
        driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]/button")).click();
        printHandles("After opening new tab");

        //driver.quit();


        // Iterate over all window handles and switch to them
        for (String window : driver.getWindowHandles()){
            driver.switchTo().window(window);
        }

        // Iterate over all windows and close them one by one
        for (String window : driver.getWindowHandles()){
            driver.switchTo().window(window);
            driver.close();
        }

    }

    private static void printHandles(String title) {
        System.out.printf("%s -------------------------\n", title);
        System.out.printf("Current window handle: %s\n", driver.getWindowHandle());
        System.out.println("All windows:");
        for (String curWindow:driver.getWindowHandles() ){
            System.out.println(curWindow);
        }



        System.out.println("-------------------------");
    }

    private static void createRemoteWebDriver() throws MalformedURLException {
        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());


    }
}
