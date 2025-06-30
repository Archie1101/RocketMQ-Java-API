package org.example.rocketmqjavaapi;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "topicTest", consumerGroup = "consumer1")
public class MQConsumerService implements RocketMQListener<String> {

    // 用于保存接收到的最新消息
    private String latestMessage;

    @Override
    public void onMessage(String message) {
        // 将接收到的消息存储为最新消息
        System.out.println("接收到的消息: " + message);
        latestMessage = message;  // 只存储最新的消息
    }

    // 提供一个方法，允许外部访问最新接收到的消息
    public String getLatestMessage() {
        return latestMessage;
    }
}
