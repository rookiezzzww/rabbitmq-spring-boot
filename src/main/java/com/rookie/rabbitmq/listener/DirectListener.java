package com.rookie.rabbitmq.listener;

import com.rookie.rabbitmq.constants.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectListener {
    @RabbitListener(queues = Constants.DIRECT_QUEUE1)
    public void listenDirectQueue1(String message) {
        System.out.println("Received message from direct.queue1: " + message);
    }
    @RabbitListener(queues = Constants.DIRECT_QUEUE2)
    public void listenDirectQueue2(String message) {
        System.out.println("Received message from direct.queue2: " + message);
    }
}
