package com.ellaend.cloud.rabbitmq.topics.customer41.receive;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Receiver {

    @RabbitListener(queues = "queue_inform_email")
    public void receiveEmail(Message message) {
        System.out.println(new String(message.getBody(), StandardCharsets.UTF_8));
    }

}
