package com.ellaend.cloud.rabbitmq.work_queues.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageSenderTest {

    @Autowired
    private MessageSender sender;

    @Test
    void sendEmail() {
        for (int i = 0; i < 10; i++) {
            sender.sendEmail(i);
        }
    }
}