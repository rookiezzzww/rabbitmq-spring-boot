package com.rookie.rabbitmq.listener;


import com.rookie.rabbitmq.constants.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkListener {
    @RabbitListener(queues = Constants.WORK_QUEUE)
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
