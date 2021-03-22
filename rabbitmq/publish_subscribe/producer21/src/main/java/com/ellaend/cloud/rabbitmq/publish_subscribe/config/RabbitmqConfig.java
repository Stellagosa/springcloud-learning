package com.ellaend.cloud.rabbitmq.publish_subscribe.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    public static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    public static final String EXCHANGE_FANOUT_INFORM_A = "exchange_fanout_inform_a";
    public static final String EXCHANGE_FANOUT_INFORM_B = "exchange_fanout_inform_b";

    //声明交换机
    @Bean(EXCHANGE_FANOUT_INFORM_A)
    public FanoutExchange EXCHANGE_FANOUT_INFORM_A() {
        // durable(true) 持久化，mq重启后交换机仍在
        return ExchangeBuilder.fanoutExchange(EXCHANGE_FANOUT_INFORM_A).durable(true).build();
    }

    @Bean(EXCHANGE_FANOUT_INFORM_B)
    public FanoutExchange EXCHANGE_FANOUT_INFORM_B() {
        // durable(true) 持久化，mq重启后交换机仍在
        return ExchangeBuilder.fanoutExchange(EXCHANGE_FANOUT_INFORM_B).durable(true).build();
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

    //QUEUE_INFORM_EMAIL 绑定 AB两个交换机
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL_A(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue, @Qualifier(EXCHANGE_FANOUT_INFORM_A) FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL_B(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue, @Qualifier(EXCHANGE_FANOUT_INFORM_B) FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }

    //QUEUE_INFORM_SMS 队列绑定交换机A
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS_A(@Qualifier(QUEUE_INFORM_SMS) Queue queue, @Qualifier(EXCHANGE_FANOUT_INFORM_A) FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }
}
