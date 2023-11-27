package com.example.config;

import com.example.handler.ClientWebSocketStompSessionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

public class ClientConfiguration {
    private static final String ENDPOINT = "ws://localhost:8082/hello-websocket";
    
    @Bean
    public WebSocketStompClient webSocketStompClient(WebSocketStompClient socketStompClient, StompSessionHandler sessionHandler) {
        var converter = new MappingJackson2MessageConverter();
        webSocketStompClient().setMessageConverter(converter);
        var stompHeader = new StompHeaders();
        Object[] urlVariables = new Object[]{};
        socketStompClient.connectAsync(ENDPOINT, null, stompHeader, sessionHandler, urlVariables);
        return socketStompClient;
    }
    
    @Bean
    public WebSocketStompClient webSocketStompClient() {
        var webSocketClient = new StandardWebSocketClient();
        return new WebSocketStompClient(webSocketClient);
    }
    
    @Bean
    public StompSessionHandler stompSessionHandler(ObjectMapper objectMapper) {
        return new ClientWebSocketStompSessionHandler(objectMapper);
    }
    
}
