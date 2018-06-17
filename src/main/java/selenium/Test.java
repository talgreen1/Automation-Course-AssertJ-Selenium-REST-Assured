package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Collections;

public class Test {

    public static void main(String[] args) throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "c:/temp/selenium/latest/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "c:/temp/selenium/latest/chromedriver.exe");

//        ChromeDriver driver = new ChromeDriver();
//        FirefoxDriver driver = new FirefoxDriver();




//        HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
//        URL url = executor.getAddressOfRemoteServer();
//        SessionId session_id = driver.getSessionId();


//        System.out.println("URL: " + url);
//        System.out.println("SessionId: " + session_id);


        RemoteWebDriver driver2 = createDriverFromSession(new SessionId("4cb51ed3-5f80-4c5e-abe1-2f2b842f1634"), new URL("http://localhost:17932"));
//        driver2.get("http://www.google.com");


        driver2.findElement(By.id("gh-ac")).sendKeys("sdfsdfsdf");


    }

    public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor){
        CommandExecutor executor = new HttpCommandExecutor(command_executor) {

            @Override
            public Response execute(Command command) throws IOException {
                Response response = null;
                if (command.getName() == "newSession") {
                    response = new Response();
                    response.setSessionId(sessionId.toString());
                    response.setStatus(0);
                    response.setValue(Collections.<String, String>emptyMap());

                    try {
                        Field commandCodec = null;
                        commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
                        commandCodec.setAccessible(true);
                        commandCodec.set(this, new W3CHttpCommandCodec());

                        Field responseCodec = null;
                        responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
                        responseCodec.setAccessible(true);
                        responseCodec.set(this, new W3CHttpResponseCodec());
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                } else {
                    response = super.execute(command);
                }
                return response;
            }
        };

        return new RemoteWebDriver(executor, new DesiredCapabilities());
    }

}
