package com.ellaend.cloud.rabbitmq.routing.customer31.receive;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Receiver {

    @RabbitListener(queues = "queue_inform_email")
    public void receiveEmail(Message message) {
        String str = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println(str);
    }

}
