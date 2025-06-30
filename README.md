# 项目简介

注意看pom中的依赖项，需要依赖一个`rocketmq-spring-boot-starter`，先用Maven配置好依赖。

然后在`application.properties`中配置NameServer的IP，我用的是虚拟机上的mq服务，虚拟机的IP是`192.168.121.221`。

`RocketmqController`编写的是API路径，`@RestController`是Spring Framework中用于标识一个控制器类的注解，它的作用是将该类标识为一个RESTful API控制器。

接下来直接启动`RocketmqApplication`，这样就在本地启动的API服务，端口默认的是8080。

我已经写了一个简单的API测试：

- `http://localhost:8080//api/test` 这里会得到一个返回的JSON，包括键fruits和counts，在前端绘制一张柱状图作为测试

数据源实时将消息发送到broker（例如10s发送一次消息），前端根据发送的消息自动更新

前段测试Vue3`https://github.com/Archie1101/HPTV-Vue`

将项目build后放入Apache服务器中的htdocs文件夹，并且注意修改`httpd.conf`

然后通过 `http://localhost:8888` 访问前端，或是直接在Vite的 `http://localhost:5173` 进行测试

前提是跨域访问设置正确