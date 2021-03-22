package com.ellaend.cloud.rabbitmq.topics.producer.product;

import com.ellaend.cloud.rabbitmq.topics.producer.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEmail(int key) {
        String message = "email: " + key;
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPIC_INFORM, "routing.key.email", message);
    }

    public void sendSms(int key) {
        String message = "sms: " + key;
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPIC_INFORM, "routing.key.sms", message);
    }
}
