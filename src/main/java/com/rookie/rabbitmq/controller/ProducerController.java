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
}
