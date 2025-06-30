package org.example.rocketmqjavaapi;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "topicTest", consumerGroup = "consumer1")
public class MQConsumerService implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("接收到的消息: " + message);
    }
}
