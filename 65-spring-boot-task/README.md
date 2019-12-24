## SpringBoot 利用 `@Scheduled` 创建定时任务
## 实现步骤
1. 在项目主类中加入`@EnableScheduling`注解
2. 创建定时任务实现类，注意加上注解`@Scheduled`

### 注意：
**cron、fixedDelay、fixedRate 三者之间不能共存！！！**

### 官方文档
*  实例文档 : http://spring.io/guides/gs/scheduling-tasks/
*  注解文档 : http://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/annotation/Scheduled.html
 