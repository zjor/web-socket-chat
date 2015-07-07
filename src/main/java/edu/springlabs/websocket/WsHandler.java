package edu.springlabs.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
public class WsHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Object cookies = session.getAttributes().get(HttpHeaders.COOKIE);
        log.info("cookies: {}; message: {}", cookies, message);
        session.sendMessage(message);
    }
}
