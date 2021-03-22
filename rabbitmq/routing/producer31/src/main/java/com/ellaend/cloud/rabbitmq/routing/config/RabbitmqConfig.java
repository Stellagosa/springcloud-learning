package com.ellaend.cloud.rabbitmq.routing.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    public static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    public static final String EXCHANGE_DIRECT_INFORM = "exchange_direct_inform";
    public static final String EMAIL_ROUTING_KEY = "email";
    public static final String SMS_ROUTING_KEY = "sms";

    //声明交换机
    @Bean(EXCHANGE_DIRECT_INFORM)
    public DirectExchange EXCHANGE_DIRECT_INFORM() {
        // durable(true) 持久化，mq重启后交换机仍在
        return ExchangeBuilder.directExchange(EXCHANGE_DIRECT_INFORM).durable(true).build();
    }

    //声明 QUEUE_INFORM_EMAIL 队列
    @Bean(QUEUE_INFORM_EMAIL)
    public Queue QUEUE_INFORM_EMAIL() {
        return new Queue(QUEUE_INFORM_EMAIL);
    }

    //声明 QUEUE_INFORM_SMS 队列
    @Bean(QUEUE_INFORM_SMS)
    public Queue QUEUE_INFORM_SMS() {
        return new Queue(QUEUE_INFORM_SMS);
    }

    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue, @Qualifier(EXCHANGE_DIRECT_INFORM) DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(EMAIL_ROUTING_KEY);
    }
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(QUEUE_INFORM_SMS) Queue queue, @Qualifier(EXCHANGE_DIRECT_INFORM) DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(SMS_ROUTING_KEY);
    }

}
