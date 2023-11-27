package com.example.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
@Slf4j
public class ClientWebSocketStompSessionHandler extends StompSessionHandlerAdapter {
    
    private final ObjectMapper objectMapper;
    private static final String SUBSCRIPTION_TOPIC = "/topic/simple";
    private static final String PUBLISH_DEST = "/app/simple";
    
    public ClientWebSocketStompSessionHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    
    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        log.info(">>> handleFrame, {}", headers);
    }
    
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        super.afterConnected(session, connectedHeaders);
    }
    
    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers,
        byte[] payload, Throwable exception) {
        super.handleException(session, command, headers, payload, exception);
    }
    
    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        super.handleTransportError(session, exception);
    }
}
