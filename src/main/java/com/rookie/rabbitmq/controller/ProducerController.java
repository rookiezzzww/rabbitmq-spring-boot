package com.rookie.rabbitmq.controller;

import com.rookie.rabbitmq.constants.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/work")
    public String work() {
        String msg = "hello String amqp";
        rabbitTemplate.convertAndSend("", Constants.WORK_QUEUE, msg);
        return "发送成功: " + msg;
    }

    /**
     * 广播模式为生产者发送给交换机，交换机发送给所有绑定该交换机的队列
     */
    @RequestMapping("/fanout")
    public String fanout() {
        String msg = "hello fanout amqp";
        rabbitTemplate.convertAndSend(Constants.FANOUT_EXCHANGE_NAME, "", msg);
        return "发送成功: " + msg;
    }

    /**
     * direct模式为生产者发送给交换机，交换机根据routingKey发送给对应的队列
     * @param routingKey
     */
    @RequestMapping("/direct")
    public String direct(String routingKey) {
        String msg = "hello direct amqp " + routingKey;
        rabbitTemplate.convertAndSend(Constants.DIRECT_EXCHANGE_NAME, routingKey, msg);
        return "发送成功: " + msg;
    }
}
