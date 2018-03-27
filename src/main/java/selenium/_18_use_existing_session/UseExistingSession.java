package selenium._18_use_existing_session;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

public class UseExistingSession {

    public static void main(String[] args) throws MalformedURLException {

        // Set your drivers locations
        System.setProperty("webdriver.gecko.driver", "c:/temp/selenium/latest/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "c:/temp/selenium/latest/chromedriver.exe");

        //------------------------------------------------------------------------
        // First run - create the relevant driver without using standalone server
        // After creating it - extract the url & session id and copy them. You will need
        // to use them in the second run in order to attach to the existing browser
        //--------------------------------------------------------------------------

        ChromeDriver driver = new ChromeDriver();
//        FirefoxDriver driver = new FirefoxDriver();


        HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
        URL url = executor.getAddressOfRemoteServer();
        SessionId session_id = driver.getSessionId();
        System.out.println("URL: " + url);
        System.out.println("SessionId: " + session_id);


        //------------------------------------------------------------------------
        // All future runs - Use the url & session ID in order to attach the existing browser
        //--------------------------------------------------------------------------
//        RemoteWebDriver driver2 = createDriverFromSession(new SessionId("10564e082d0622529435aef7e74943e6"), new URL("http://localhost:18669"));
//        driver2.get("http://www.ebay.com");
    }

    public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor) {
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
