package mocking.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class StubForGet {
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

        // At the end - stop the server
//        wireMockServer.stop();
    }
}
