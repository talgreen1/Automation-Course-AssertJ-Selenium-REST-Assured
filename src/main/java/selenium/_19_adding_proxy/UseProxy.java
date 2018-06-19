package selenium._19_adding_proxy;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class UseProxy {
    public static void main(String[] args) throws MalformedURLException {
        String PROXY = "one.proxy.att.com:8080";
        Proxy proxy = new Proxy();
        proxy.setProxyType(Proxy.ProxyType.MANUAL);
        proxy.setHttpProxy(PROXY);
        proxy.setSslProxy(PROXY);
        proxy.setAutodetect(false);

        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(CapabilityType.PROXY, proxy);

        WebDriver driver = new RemoteWebDriver(
                new URL("http://135.76.2.19:4444/wd/hub"),
                dc);

    }
}
