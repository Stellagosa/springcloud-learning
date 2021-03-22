package com.ellaend.cloud.rabbitmq.routing.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageSenderTest {

    @Autowired
    private MessageSender sender;

    @Test
    void send() {
        for (int i = 0; i < 2; i++) {
            sender.sendEmail(i);
            sender.sendSms(i);
        }
    }
}