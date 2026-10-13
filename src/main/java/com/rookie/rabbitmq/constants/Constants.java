package com.rookie.rabbitmq.constants;

public class Constants {
    //1. work queue
    public static final String WORK_QUEUE = "work_queue";

    //2. 发布订阅模式
    //2.1fanout
    public static final String FANOUT_QUEUE1 = "fanout_queue1";
    public static final String FANOUT_QUEUE2 = "fanout_queue2";
    public static final String FANOUT_EXCHANGE_NAME = "fanout_exchange";
    //2.2direct
    public static final String DIRECT_QUEUE1 = "direct_queue1";
    public static final String DIRECT_QUEUE2 = "direct_queue2";
    public static final String DIRECT_EXCHANGE_NAME = "direct_exchange";
}
