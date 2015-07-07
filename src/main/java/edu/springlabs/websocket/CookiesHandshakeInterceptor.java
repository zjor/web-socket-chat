package edu.springlabs.websocket;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

public class CookiesHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse,
            WebSocketHandler webSocketHandler,
            Map<String, Object> attributes) throws Exception {

        attributes.put(HttpHeaders.COOKIE, serverHttpRequest.getHeaders().get(HttpHeaders.COOKIE));
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
