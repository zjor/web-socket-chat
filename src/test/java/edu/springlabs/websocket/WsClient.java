package edu.springlabs.websocket;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.ContainerProvider;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import java.io.IOException;
import java.net.URI;

@Slf4j
public class WsClient {
    public static void main(String[] args) throws Exception {

        ContainerProvider.getWebSocketContainer().connectToServer(new Endpoint() {
            @Override
            public void onOpen(Session session, EndpointConfig endpointConfig) {
                System.out.println("Connected: " + session);
                try {
                    session.getBasicRemote().sendText("Hello world");
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }


            }
        }, new URI("ws://localhost:7001/websocket/wsHandler"));



    }
}
