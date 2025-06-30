注意看pom中的依赖项，需要依赖一个rocketmq-spring-boot-starter，先用Maven配置好依赖
然后在application.properties中配置NameSever的ip，我用的是虚拟机上的mq服务，虚拟机的ip是192.168.121.221
RocketmqController编写的是api路径，@RestController 是 Spring Framework 中用于标识一个控制器类的注解，它的作用是将该类标识为一个 RESTful API 控制器。
然后直接启动RocketmqApplication
这样就在本地启动的api服务，端口默认的是8080
我已经写了一个简单的api测试
http://localhost:8080/api/test
返回1,2,3,4
http://localhost:8080/sendMessage?topic=topicTest&message=HelloWorld
参数中topic为topicTest，那么消息就会发送到topicTest中，在DashBoard中就可以看到这个新出现的topic
