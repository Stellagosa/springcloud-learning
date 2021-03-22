package com.ellaend.cloud.rabbitmq.routing.customer32.receive;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Receiver {

    @RabbitListener(queues = "queue_inform_sms")
    public void receiveEmail(Object msg, Message message, Channel channel) {
        System.out.println("queue_inform_sms, msg: " + msg);
        System.out.println(message);
        System.out.println(channel);
        String str = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println(str);
    }
}