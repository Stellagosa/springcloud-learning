package com.ellaend.cloud.rabbitmq.topics.customer42.receive;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Receiver {

    @RabbitListener(queues = "queue_inform_sms")
    public void receiveSms(Message message) {
        System.out.println(new String(message.getBody(), StandardCharsets.UTF_8));
    }

}
