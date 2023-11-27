package com.example.contoller;

import com.example.dto.SimpleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class SimpleMessageController {
    
    @MessageMapping("/simple-message")
    @SendTo("/topic/simple")
    public void simpleMessage(SimpleMessage simpleMessage) {
        log.info("Received Message >>> {} ", simpleMessage.message());
    }
}
