package com.templateproject.api.config;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class LoginHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Gérez la requête de type 2 ici
        String payload = message.getPayload();
        // Faites quelque chose avec le payload de la requête 2
    }
}

