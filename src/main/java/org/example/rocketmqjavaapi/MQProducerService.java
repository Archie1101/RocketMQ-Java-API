package org.example.rocketmqjavaapi;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

    // 定时任务，发送消息到指定topic，每分钟发送一次
    @Scheduled(fixedRate = 10000) // 每60秒发送一次
    public void sendScheduledMessage() {
        String topic = "topicTest"; // 你可以根据需要动态设置topic
        String message = "定时消息：当前时间 " + System.currentTimeMillis();
        sendMessage(topic, message);
    }
}
