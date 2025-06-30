package org.example.rocketmqjavaapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;

@Service
public class MQProducerService {

    //    @Autowired 是 Spring 框架提供的一个注解，用于自动装配（自动注入）依赖关系。
    //    Spring 会根据类型自动注入合适的对象到类的成员变量、构造函数或方法中。
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    // 发送普通消息，动态指定topic
    public void sendMessage(String topic, String message) {
        rocketMQTemplate.convertAndSend(topic, message);
        System.out.println("发送消息成功: " + message + " 到 topic: " + topic);
    }

    @Scheduled(fixedRate = 10000) // 每10秒发送一次
    public void sendScheduledMessage() {
        String topic = "topicTest"; // 你可以根据需要动态设置 topic

        // 创建水果和数量的数据
        List<String> fruits = List.of("苹果", "香蕉", "橙子", "葡萄", "草莓");
        List<Integer> counts = List.of(10, 20, 30, 40, 50);

        // 将数据封装为 Map
        Map<String, Object> messageData = Map.of(
                "fruits", fruits,    // 水果列表
                "counts", counts     // 数量列表
        );

        try {
            // 将 Map 转换为 JSON 字符串
            String message = objectMapper.writeValueAsString(messageData);
            // 发送消息
            sendMessage(topic, message);
        } catch (Exception e) {
            // 捕获并打印异常
            e.printStackTrace();
        }
    }
}
