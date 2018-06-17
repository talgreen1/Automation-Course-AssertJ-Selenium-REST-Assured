package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


//        capabilities.setCapability(MobileCapabilityType.PLATFORM, "ANDROID");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "sam");
        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "Samsung S4");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

//        capabilities.setCapability("appPackage", "com.att.tlv.lattice.agent.android.testandroid");
//        capabilities.setCapability("appActivity", "com.att.tlv.lattice.agent.android.testandroid.LoginActivity");



        URL url = new URL("http://127.0.0.1:4444/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(url, capabilities);

        driver.get("http://www.yahoo.com/");


        driver.quit();
    }
}
