1. 请求127.0.0.1:8080/druid/login.html
2. 配置详细

###############################################################################
#####database使用druid
#####配置参考
####https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter
####jdbc参考网址使用spring.datasource.druid.url：springboot2启动报错；
###############################################################################
#####jdbc配置
spring.datasource.url=jdbc:mysql://192.168.1.1:3306/xxx
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

#####datasource druid pool
spring.datasource.druid.filters= stat
spring.datasource.druid.initial-size=10
spring.datasource.druid.max-active=20
spring.datasource.druid.min-idle=8

#####druid监控配置
## WebStatFilter配置，说明请参考Druid Wiki，配置_配置WebStatFilter
#是否启用StatFilter默认值true
spring.datasource.druid.web-stat-filter.enabled=true
spring.datasource.druid.web-stat-filter.url-pattern=/*
spring.datasource.druid.web-stat-filter.exclusions=*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*
#session统计功能
spring.datasource.druid.web-stat-filter.session-stat-enable=true
#最大session数
spring.datasource.druid.web-stat-filter.session-stat-max-count=100000
#你可以配置principalSessionName，使得druid能够知道当前的session的用户是谁
spring.datasource.druid.web-stat-filter.principal-session-name=admin
#你可以配置principalSessionName，使得druid能够知道当前的cookie的用户是谁
spring.datasource.druid.web-stat-filter.principal-cookie-name=admin
#置profileEnable能够监控单个url调用的sql列表。
spring.datasource.druid.web-stat-filter.profile-enable=true

## StatViewServlet配置，说明请参考Druid Wiki，配置_StatViewServlet配置
spring.datasource.druid.stat-view-servlet.enabled= true
spring.datasource.druid.stat-view-servlet.url-pattern=/druid/*
spring.datasource.druid.stat-view-servlet.reset-enable=true
spring.datasource.druid.stat-view-servlet.login-username=admin
spring.datasource.druid.stat-view-servlet.login-password=111111
spring.datasource.druid.stat-view-servlet.allow=127.0.0.1
spring.datasource.druid.stat-view-servlet.deny=192.168.10.1

## Spring监控配置，说明请参考Druid Github Wiki，配置_Druid和Spring关联监控配置
# Spring监控AOP切入点，如x.y.z.service.*,配置多个英文逗号分隔
spring.datasource.druid.aop-patterns= org.lsh.dubhe.service.*

#配置wall filter
spring.datasource.druid.filter.wall.enabled=true
spring.datasource.druid.filter.wall.db-type=mysql
spring.datasource.druid.filter.wall.config.alter-table-allow=false
spring.datasource.druid.filter.wall.config.truncate-allow=false
spring.datasource.druid.filter.wall.config.drop-table-allow=false
#是否允许非以上基本语句的其他语句，缺省关闭，通过这个选项就能够屏蔽DDL。
spring.datasource.druid.filter.wall.config.none-base-statement-allow=false
#检查UPDATE语句是否无where条件，这是有风险的，但不是SQL注入类型的风险
spring.datasource.druid.filter.wall.config.update-where-none-check=true
#SELECT ... INTO OUTFILE 是否允许，这个是mysql注入攻击的常见手段，缺省是禁止的
spring.datasource.druid.filter.wall.config.select-into-outfile-allow=false
#是否允许调用Connection.getMetadata方法，这个方法调用会暴露数据库的表信息
spring.datasource.druid.filter.wall.config.metadata-allow=true
#对被认为是攻击的SQL进行LOG.error输出
spring.datasource.druid.filter.wall.log-violation=true
#对被认为是攻击的SQL抛出SQLExcepton
spring.datasource.druid.filter.wall.throw-exception=true
 