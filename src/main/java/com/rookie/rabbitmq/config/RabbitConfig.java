package com.rookie.rabbitmq.config;

import com.rookie.rabbitmq.constants.Constants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean("workQueue")
    public Queue workQueue() {
        return new Queue(Constants.WORK_QUEUE, true);
    }

}
