package com.ellaend.cloud.rabbitmq.topics.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    public static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    public static final String EXCHANGE_TOPIC_INFORM = "exchange_TOPIC_inform";
    //符号 # 可以匹配0个或者多个词，符号 * 可以匹配一个词语
    public static final String ROUTING_KEY = "routing.key.#";
    public static final String SMS_ROUTING_KEY = "routing.key.sms.#";

    //声明交换机
    @Bean(EXCHANGE_TOPIC_INFORM)
    public TopicExchange EXCHANGE_TOPIC_INFORM() {
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPIC_INFORM).durable(true).build();
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
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue, @Qualifier(EXCHANGE_TOPIC_INFORM) TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(QUEUE_INFORM_SMS) Queue queue, @Qualifier(EXCHANGE_TOPIC_INFORM) TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(SMS_ROUTING_KEY);
    }
}
