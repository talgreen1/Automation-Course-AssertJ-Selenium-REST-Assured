package mocking.mockserver;

import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;

import static org.mockserver.integration.ClientAndProxy.startClientAndProxy;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class MockServerTest {
    public static void main(String[] args) {

        ClientAndServer mockServer;
        mockServer = startClientAndServer(1080);


        mockServer.stop();


    }
}
