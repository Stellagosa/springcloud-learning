package com.ellaend.cloud.rabbitmq.work_queues.product;

import com.ellaend.cloud.rabbitmq.work_queues.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEmail(int key) {
        String message = key + ": Send email message to user";
        rabbitTemplate.convertAndSend(RabbitmqConfig.QUEUE_INFORM_EMAIL, message);
    }
}
