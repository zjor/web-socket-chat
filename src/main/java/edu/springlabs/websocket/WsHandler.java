package edu.springlabs.websocket;

import com.google.gson.Gson;
import edu.springlabs.websocket.protocol.Login;
import edu.springlabs.websocket.protocol.Message;
import edu.springlabs.websocket.protocol.Payload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class WsHandler extends TextWebSocketHandler {

    private final static String COMMAND_LOGIN = "login";
    private final static String COMMAND_MESSAGE = "message";
    private final static String COMMAND_LOGOUT = "logout";

    private Map<String, WebSocketSession> sessions = new HashMap<>();

    private Gson gson = new Gson();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        if (!sessions.containsKey(session.getId())) {
            sessions.put(session.getId(), session);
        }

        log.info("Handling payload: {}", message.getPayload());
        Payload payload = gson.fromJson(message.getPayload(), Payload.class);
        String command = payload.getCommand();

        if (COMMAND_LOGIN.equals(command)) {

        } else if (COMMAND_MESSAGE.equals(command)) {
            handleMessage(gson.fromJson(gson.toJson(payload.getData()), Message.class), session);
        } else if (COMMAND_LOGOUT.equals(command)) {

        } else {
            //..unknown command
        }
    }

    private void handleLogin(Login login, WebSocketSession session) throws Exception {

    }

    private void handleMessage(Message message, WebSocketSession session) throws Exception {
        TextMessage response = new TextMessage(gson.toJson(message));
        sessions.values().stream().forEach(s -> {
            try {
                s.sendMessage(response);
            } catch (IOException e) {
                log.error("Failed to send message: " + e.getMessage(), e);
            }
        });

    }

    private void handleLogout(WebSocketSession session) throws Exception {

    }

}
