package org.example.rocketmqjavaapi;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQProducerService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    // 发送普通消息，动态指定topic
    public void sendMessage(String topic, String message) {
        rocketMQTemplate.convertAndSend(topic, message);
        System.out.println("发送消息成功: " + message + " 到 topic: " + topic);
    }
}
