package com.ellaend.cloud.rabbitmq.publish_subscribe.customer21.receive;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Receiver {

    @RabbitListener(queues = "queue_inform_email")
    public void receiveEmail(Object msg, Message message, Channel channel) {
        System.out.println("queue_inform_email, msg: " + msg);
        System.out.println(message);
        System.out.println(channel);
        String str = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println(str);
    }
}
