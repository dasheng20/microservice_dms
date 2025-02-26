package com.dms.user.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    private String exchange = "spring-boot-exchange";
    private String routingKey = "spring-boot-routing";

    public void send(String message) {
        System.out.println("Sending message: " + message);
        amqpTemplate.convertAndSend(exchange, routingKey, message);
    }
}