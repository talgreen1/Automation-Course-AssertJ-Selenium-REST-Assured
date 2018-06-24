package mocking.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.VerificationException;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.matching.StringValuePattern;
import com.github.tomakehurst.wiremock.stubbing.ServeEvent;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@SuppressWarnings("Duplicates")

public class WireMockSamples {
    public static void main(String[] args) {
        stubForGet();
        stubForPostWithHeaders();

        stubWithVerify();
        stubWithVerify2Times();

        stubWithVerifyandExtractRequests();
        stubWithRetryVerify();
        stubWithRetryVerify2();


    }

    private static void stubWithRetryVerify2() {
        // Init the wire mock to listen on port
        int port = 7979;
        WireMockServer wireMockServer = new WireMockServer( wireMockConfig().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        // Add 1 stub to the mock server. A stub is a mapping between a request and a response.
        stubFor(post(urlPathMatching(".*"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Hello response")));


        RetryPolicy retryPolicy = new RetryPolicy()
                .retryOn(VerificationException.class)
                .withDelay(5, TimeUnit.SECONDS)
                .withMaxRetries(5);

        Failsafe.with(retryPolicy)
                .onRetry((c, f, ctx) -> System.out.printf("Failure #%s. Retrying.", ctx.getExecutions()))
                .run(() -> {
                    verify(postRequestedFor(urlEqualTo("/verify/this"))
                            .withHeader("Content-Type", equalTo("text/xml")));
                });

        // At the end - stop the server
//        wireMockServer.stop();
    }
    private static void stubWithRetryVerify() {
        // Init the wire mock to listen on port
        int port = 7979;
        WireMockServer wireMockServer = new WireMockServer( wireMockConfig().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        // Add 1 stub to the mock server. A stub is a mapping between a request and a response.
        stubFor(post(urlPathMatching(".*"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Hello response")));


        RetryPolicy retryPolicy = new RetryPolicy()
                .retryOn(VerificationException.class)
                .withDelay(5, TimeUnit.SECONDS)
                .withMaxRetries(5);

        Failsafe.with(retryPolicy)
                .run(() -> {
                    verify(postRequestedFor(urlEqualTo("/verify/this"))
                            .withHeader("Content-Type", equalTo("text/xml")));
                });

        // At the end - stop the server
//        wireMockServer.stop();
    }

    /**
     * This method verify that the stub was executed exactly 2 times
     */
    private static void stubWithVerify2Times() {
        // Init the wire mock to listen on port
        int port = 7979;
        WireMockServer wireMockServer = new WireMockServer( wireMockConfig().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        // Add 1 stub to the mock server. A stub is a mapping between a request and a response.
        stubFor(post(urlEqualTo("/users/add"))
                .withHeader("Content-Type", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Hello from POST with Header")));


        verify(2, postRequestedFor(urlEqualTo("/users/add"))
                .withHeader("Content-Type", equalTo("text/xml")));

        // At the end - stop the server
//        wireMockServer.stop();
    }

    /**
     * This method verify that the stub was executed and extract the request
     */
    private static void stubWithVerifyandExtractRequests() {
        // Init the wire mock to listen on port
        int port = 7979;
        WireMockServer wireMockServer = new WireMockServer( wireMockConfig().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        // Add 1 stub to the mock server. A stub is a mapping between a request and a response.
        stubFor(post(urlEqualTo("/users/add"))
                .withHeader("Content-Type", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Hello from POST with Header")));


        List<ServeEvent> allServeEvents = getAllServeEvents();
        for (ServeEvent allServeEvent : allServeEvents) {
            System.out.println(allServeEvent.getRequest().getUrl());
        }

        // At the end - stop the server
//        wireMockServer.stop();
    }

    /**
     * This method verify that the stub was executed
     */
    private static void stubWithVerify() {
        // Init the wire mock to listen on port
        int port = 7979;
        WireMockServer wireMockServer = new WireMockServer( wireMockConfig().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        // Add 1 stub to the mock server. A stub is a mapping between a request and a response.
        stubFor(post(urlEqualTo("/users/add"))
                .withHeader("Content-Type", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Hello from POST with Header")));


        verify(postRequestedFor(urlEqualTo("/users/add"))
                .withHeader("Content-Type", equalTo("text/xml")));

        // At the end - stop the server
//        wireMockServer.stop();
    }

    /**
     * Stubbing for POST request for "/users" path with "Content-Type" header of "text/xml"
     */
    private static void stubForPostWithHeaders() {
        // Init the wire mock to listen on port
        int port = 7979;
        WireMockServer wireMockServer = new WireMockServer( wireMockConfig().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        // Add 1 stub to the mock server. A stub is a mapping between a request and a response.
        stubFor(post(urlEqualTo("/users"))
                .withHeader("Content-Type", equalTo("text/xml"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Hello from POST with Header")));

        // At the end - stop the server
//        wireMockServer.stop();
    }

    /**
     * Stubbing for ANY get API request
     */
    private static void stubForGet(){
        // Init the wire mock to listen on port
        int port = 7979;
        WireMockServer wireMockServer = new WireMockServer( wireMockConfig().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        // Add 1 stub to the mock server. A stub is a mapping between a request and a response.
        stubFor(get(urlPathMatching(".*"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Hello from GET request")));

        // At the end - stop the server
//        wireMockServer.stop();
    }
}
