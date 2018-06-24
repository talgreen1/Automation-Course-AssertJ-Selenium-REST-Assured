package mocking.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.VerificationException;
import com.github.tomakehurst.wiremock.client.WireMock;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.TimeUnit;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WireMockTest {
    public static void main(String[] args) {

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
//                .onRetry(failure -> System.out.println("Connection attempts failed" + failure.getMessage()) )
                .run(() -> {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            verify(postRequestedFor(urlEqualTo("/verify/this"))
                    .withHeader("Content-Type", equalTo("text/xml")));
        });


//        verify(postRequestedFor(urlEqualTo("/verify/this"))
//                .withHeader("Content-Type", equalTo("text/xml")));

        // At the end - stop the server
        wireMockServer.stop();
    }
}
