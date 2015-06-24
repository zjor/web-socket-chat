package cz.royz;

import lombok.extern.slf4j.Slf4j;
import org.glassfish.tyrus.server.Server;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Slf4j
@ServerEndpoint(ChatServer.ENDPOINT_PATH)
public class ChatServer {

    public static final String ENDPOINT_PATH = "/ws/chat";
    public static final int PORT = 8456;

    @OnOpen
    public void onOpen(Session session) {
        log.info("{}", session);

    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("{}: {}", message, session);
        session.getAsyncRemote().sendText(message);
    }

    @OnClose
    public void onClose(Session session) {
        log.info("{}", session);

    }

    public static void main(String[] args) throws DeploymentException, IOException {
        Server server = new Server("localhost", PORT, "/", ChatServer.class);
        server.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        log.info("Please press a key to stop the server.");
        reader.readLine();
    }


}
