分区访问进行测试
http://localhost:8080/actuator/health
http://localhost:8080/actuator/battcn
http://localhost:8080/actuator/info


SpringBoot 是为了简化 Spring 应用的创建、运行、调试、部署等一系列问题而诞生的产物，自动装配的特性让我们可以更好的关注业务本身而不是外部的XML配置，我们只需遵循规范，引入相关的依赖就可以轻易的搭建出一个 WEB 工程

actuator是spring boot项目中非常强大一个功能，有助于对应用程序进行监视和管理，通过 restful api 请求来监管、审计、收集应用的运行情况，针对微服务而言它是必不可少的一个环节…

Endpoints

actuator 的核心部分，它用来监视应用程序及交互，spring-boot-actuator中已经内置了非常多的 Endpoints（health、info、beans、httptrace、shutdown等等），同时也允许我们自己扩展自己的端点

Spring Boot 2.0 中的端点和之前的版本有较大不同,使用时需注意。另外端点的监控机制也有很大不同，启用了不代表可以直接访问，还需要将其暴露出来，传统的management.security管理已被标记为不推荐。


在 application.properties 文件中配置actuator的相关配置，其中info开头的属性，就是访问info端点中显示的相关内容，值得注意的是Spring Boot2.x中，默认只开放了info、health两个端点，剩余的需要自己通过配置management.endpoints.web.exposure.include属性来加载（有include自然就有exclude，不做详细概述了）。如果想单独操作某个端点可以使用management.endpoint.端点.enabled属性进行启用或禁用

自定义 - 重点

上面讲了很多都是配置相关，以及自带的一些端点，在实际应用中有时候默认并不能满足我们的要求，比如Spring Boot默认的健康端点就很有可能不能满足

健康端点（第一种方式）

实现HealthIndicator接口，根据自己的需要判断返回的状态是UP还是DOWN，功能简单。

健康端点（第二种方式）

继承AbstractHealthIndicator抽象类，重写doHealthCheck方法，功能比第一种要强大一点点，默认的DataSourceHealthIndicator 、 RedisHealthIndicator 都是这种写法，内容回调中还做了异常的处理。

