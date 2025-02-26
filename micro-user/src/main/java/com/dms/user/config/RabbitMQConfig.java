package com.dms.user.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // 定义队列
    @Bean
    public Queue queue() {
        return new Queue("spring-boot-queue", false);
    }

    // 定义交换机
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("spring-boot-exchange");
    }

    // 绑定队列到交换机，使用 routingKey
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("spring-boot-routing");
    }
}
