package com.capstone.review.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitProductRepository {
    final static String SEND_QUEUE = "spring.python.product";
    final static String RECEIVE_QUEUE = "python.spring.product";
    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void send(String  message){
        MessageProperties properties = new MessageProperties();
        Message sendMessage = rabbitTemplate.getMessageConverter().toMessage(message,properties);
        rabbitTemplate.send(SEND_QUEUE,sendMessage);
    }
    public String receive(){
        Message message = rabbitTemplate.receive(RECEIVE_QUEUE,2000L);
        String result = new String(message.getBody());
        return result;
    }
}