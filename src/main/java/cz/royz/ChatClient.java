package cz.royz;

import lombok.extern.slf4j.Slf4j;
import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@ClientEndpoint
public class ChatClient {

    @OnOpen
    public void onOpen(Session session) {
        log.info("{}", session);

    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("{}: {}", message, session);
//        session.getAsyncRemote().sendText(message);
    }

    @OnClose
    public void onClose(Session session) {
        log.info("{}", session);
    }

    public static void main(String[] args) throws URISyntaxException, DeploymentException, IOException, InterruptedException {
        ClientManager clientManager = ClientManager.createClient();
        Session session = clientManager.connectToServer(ChatClient.class, new URI("ws://localhost:" + ChatServer.PORT + ChatServer.ENDPOINT_PATH));
        session.getBasicRemote().sendText("hello world");
        Thread.sleep(1000L);
        session.close();
    }


}
