package org.example.rocketmqjavaapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RocketmqController {

    @Autowired
    private MQProducerService mqProducerService;

    // 通过 GET 请求发送消息
    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
        try {
            mqProducerService.sendMessage(topic, message);
            return "Message sent successfully!";
        } catch (Exception e) {
            return "Failed to send message: " + e.getMessage();
        }
    }

    @GetMapping("/api/test")
    public Map<String, Object> getTestData() {
        // 返回 JSON 格式的响应
        return Map.of("data", new int[]{1, 2, 3, 4});
    }
}
