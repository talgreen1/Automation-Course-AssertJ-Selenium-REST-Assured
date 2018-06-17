package selenium._17_desiredcapabilities;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class DesiredCaps {

    private static WebDriver driver = null;
    public static void main(String[] args) throws MalformedURLException, FileNotFoundException {


        System.out.println(getJsonFromDesiredCapabilities(DesiredCapabilities.chrome()));

        Capabilities caps = getDesiredCapabilitesFromJsonFile("./src/main/java/selenium/_17_desiredcapabilities/chrome-incognito.json");


        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                caps);

//        createFFDriver();

        driver.get("http://www.google.com");

        System.out.println(driver.getTitle());
        driver.quit();
    }

    public static String getJsonFromDesiredCapabilities(Capabilities dc){
        Gson gson = new Gson();
        return gson.toJson(dc);
    }

    public static MutableCapabilities getDesiredCapabilitesFromJsonFile(String jsonFilePath) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader(jsonFilePath));
        MutableCapabilities dc = (MutableCapabilities)gson.fromJson(jsonReader, MutableCapabilities.class);

        String s ="sdfs";
        s.toCharArray();
        return dc;
    }

    public static void createFFDriver() throws MalformedURLException {

        DesiredCapabilities caps = DesiredCapabilities.firefox();




        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");
        options.setHeadless(true);

        caps.merge(options);

        System.out.println(getJsonFromDesiredCapabilities(caps));
        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                caps);

    }





}
