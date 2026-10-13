package com.rookie.rabbitmq.listener;

import com.rookie.rabbitmq.constants.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutListener {
    @RabbitListener(queues = Constants.FANOUT_QUEUE1)
    public void listen1(String message) {
        System.out.println("FanoutListener1: " + message);
    }
    @RabbitListener(queues = Constants.FANOUT_QUEUE2)
    public void listen(String message) {
        System.out.println("FanoutListener2: " + message);
    }
}
