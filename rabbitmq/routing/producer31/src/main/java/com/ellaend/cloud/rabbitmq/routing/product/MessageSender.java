package com.ellaend.cloud.rabbitmq.routing.product;

import com.ellaend.cloud.rabbitmq.routing.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEmail(int key) {
        String message = "email: " + key;
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_DIRECT_INFORM, RabbitmqConfig.EMAIL_ROUTING_KEY,  message);
    }

    public void sendSms(int key) {
        String message = "sms: " + key;
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_DIRECT_INFORM, RabbitmqConfig.SMS_ROUTING_KEY,  message);
    }
}
