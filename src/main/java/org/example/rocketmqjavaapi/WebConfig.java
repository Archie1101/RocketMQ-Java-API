package org.example.rocketmqjavaapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // 标识这是一个配置类
public class WebConfig implements WebMvcConfigurer {

    // 重写 addCorsMappings 方法来配置跨域访问
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 配置所有路径都允许跨域
//              .allowedOrigins("http://localhost:8888")
                .allowedOrigins("http://localhost:8888", "http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的请求方法
                .allowedHeaders("*")  // 允许的请求头
                .allowCredentials(true);  // 允许携带凭证（如 Cookies）
    }
}
