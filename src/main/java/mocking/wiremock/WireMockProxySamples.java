package mocking.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.VerificationException;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.stubbing.ServeEvent;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockProxySamples {
    public static void main(String[] args) {

        proxyAllRequestToAnotherServer();
        monitorStandAlonProxyServer();
        waitForSpecificRequest();
    }

    private static void waitForSpecificRequest() {
//        Start the mock server as proxy from command line:
//      java -jar wiremock-standalone-2.18.0.jar --port 7979 --root-dir c:/temp/mappings

        WireMock.configureFor("localhost", 7979);

        // Clear all requests if needed
        WireMock.resetAllRequests();

        RetryPolicy retryPolicy = new RetryPolicy()
                .retryOn(VerificationException.class)
                .withDelay(5, TimeUnit.SECONDS)
                .withMaxRetries(5);

        Failsafe.with(retryPolicy)
                .run(() -> verify(getRequestedFor(urlEqualTo("/get"))));
    }

    private static void monitorStandAlonProxyServer() {

//      Start the mock server as proxy from command line:
//      java -jar wiremock-standalone-2.18.0.jar --port 7979 --root-dir c:/temp/mappings

        WireMock.configureFor("localhost", 7979);

        // Clear all requests if needed
//        WireMock.resetAllRequests();

        // Iterate over all requests
        List<ServeEvent> allServeEvents = getAllServeEvents();
        for (ServeEvent allServeEvent : allServeEvents) {
            System.out.println(allServeEvent.getRequest().getUrl());
            System.out.println(allServeEvent.getResponse().getStatus());
            System.out.println("----------------------------------");
        }


    }

    private static void proxyAllRequestToAnotherServer() {
        int port = 7979;
        WireMockServer wireMockServer = new WireMockServer( wireMockConfig().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        stubFor(post(urlMatching(".*"))
                .willReturn(aResponse().proxiedFrom("http://httpbin.org/")));

//        At the end - stop the server
//        wireMockServer.stop();
    }
}
