package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    
    private static final String END_POINT = "/hello-socket";
    private static final String SIMPLE_BROKER = "/topic";
    private static final String PUBLISH = "/app";
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(SIMPLE_BROKER); // 브로커 이름을 설정
        registry.setApplicationDestinationPrefixes(PUBLISH); // 메시지가 어디로 routing되어 처리될 지 설정
    }
    
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
            .addEndpoint(END_POINT)
            .setAllowedOrigins("*");
    }
}
