# 项目简介

注意看pom中的依赖项，需要依赖一个`rocketmq-spring-boot-starter`，先用Maven配置好依赖。

然后在`application.properties`中配置NameServer的IP，我用的是虚拟机上的mq服务，虚拟机的IP是`192.168.121.221`。

`RocketmqController`编写的是API路径，`@RestController`是Spring Framework中用于标识一个控制器类的注解，它的作用是将该类标识为一个RESTful API控制器。

接下来直接启动`RocketmqApplication`，这样就在本地启动的API服务，端口默认的是8080。

我已经写了一个简单的API测试：

- `http://localhost:8080/api/test` 返回 `1, 2, 3, 4`
- `http://localhost:8080/sendMessage?topic=topicTest&message=HelloWorld`
  - 参数中`topic`为`topicTest`，那么消息就会发送到`topicTest`中，在DashBoard中就可以看到这个新出现的topic。

但是我仍不确定项目应该设计为以下的哪种情况

1.前端每请求一次数据，那么数据源就发送一次消息到broker，然后前端更新数据

2.数据源实时将消息发送到broker（例如1分钟发送一次消息），前端根据发送的消息自动更新

我个人倾向为数据源实时发送消息，前端自动处理，因为大屏数据应该是实时展示的，而不是用户刷新一次，大屏才刷新一次
