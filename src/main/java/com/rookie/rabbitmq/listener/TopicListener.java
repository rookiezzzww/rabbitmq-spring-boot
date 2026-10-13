package com.rookie.rabbitmq.listener;

import com.rookie.rabbitmq.constants.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {
    @RabbitListener(queues = Constants.TOPIC_QUEUE1)
    public void process(String msg) {
        System.out.println("TopicListener1接收到消息: " + msg);
    }
    @RabbitListener(queues = Constants.TOPIC_QUEUE2)
    public void process2(String msg) {
        System.out.println("TopicListener2接收到消息: " + msg);
    }
}
