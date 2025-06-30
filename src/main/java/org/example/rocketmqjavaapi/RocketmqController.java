package org.example.rocketmqjavaapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RocketmqController {

    // 自动注入 MQConsumerService
    @Autowired
    private MQConsumerService mqConsumerService;

    // 创建一个接口，返回 Consumer 接收到的消息
    @GetMapping("/api/test")
    public String getReceivedMessages() {
        return mqConsumerService.getLatestMessage();
    }
}
