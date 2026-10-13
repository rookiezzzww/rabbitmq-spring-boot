package com.rookie.rabbitmq.config;

import com.rookie.rabbitmq.constants.Constants;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    // 1.工作队列模式
    @Bean("workQueue")
    public Queue workQueue() {
        return QueueBuilder.durable(Constants.WORK_QUEUE).build();
    }

    // 2.发布订阅模式
    // 2.1 fanout
    @Bean("fanoutQueue1")
    public Queue fanoutQueue1() {
        return QueueBuilder.durable(Constants.FANOUT_QUEUE1).build();
    }
    @Bean("fanoutQueue2")
    public Queue fanoutQueue2() {
        return QueueBuilder.durable(Constants.FANOUT_QUEUE2).build();
    }
    // 声明交换机
    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange(Constants.FANOUT_EXCHANGE_NAME).durable(true).build();
    }
    // 声明和交换机绑定
    @Bean
    public Binding bindQueue1ToExchange(@Qualifier("fanoutQueue1") Queue queue, @Qualifier("fanoutExchange") FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }
    @Bean
    public Binding bindQueue2ToExchange(@Qualifier("fanoutQueue2") Queue queue, @Qualifier("fanoutExchange") FanoutExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange);
    }
    // 2.2 direct
    @Bean("directQueue1")
    public Queue directQueue1() {
        return QueueBuilder.durable(Constants.DIRECT_QUEUE1).build();
    }
    @Bean("directQueue2")
    public Queue directQueue2() {
        return QueueBuilder.durable(Constants.DIRECT_QUEUE2).build();
    }
    // 声明交换机
    @Bean("directExchange")
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(Constants.DIRECT_EXCHANGE_NAME).durable(true).build();
    }
    // 声明和交换机绑定
    @Bean
    public Binding bindQueue1ToDirectExchange(@Qualifier("directQueue1") Queue queue, @Qualifier("directExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("orange");
    }
    @Bean
    public Binding bindQueue2ToDirectExchange(@Qualifier("directQueue2") Queue queue, @Qualifier("directExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("black");
    }
}
