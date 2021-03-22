package com.ellaend.cloud.rabbitmq.publish_subscribe.product;

import com.ellaend.cloud.rabbitmq.routing.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //发送消息到 A 交换机
    public void sendA(int key) {
        String message = "交换机A: " + key;
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_FANOUT_INFORM_A, "",  message);
    }
    //发送消息到B交换机
    public void sendB(int key) {
        String message = "交换机B: " + key;
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_FANOUT_INFORM_B, "",  message);
    }
}
