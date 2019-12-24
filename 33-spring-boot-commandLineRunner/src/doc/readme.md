##SpringBoot之CommandLineRunner接口和ApplicationRunner接口

我们在开发中可能会有这样的情景。需要在容器启动的时候执行一些内容。比如读取配置文件，数据库连接之类的。SpringBoot给我们提供了两个接口来帮助我们实现这种需求。这两个接口分别为CommandLineRunner和ApplicationRunner。他们的执行时机为容器启动完成的时候。

这两个接口中有一个run方法，我们只需要实现这个方法即可。这两个接口的不同之处在于：ApplicationRunner中run方法的参数为ApplicationArguments，而CommandLineRunner接口中run方法的参数为String数组。下面我写两个简单的例子，来看一下这两个接口的实现。

CommandLineRunner

具体代码如下：
```
package com.zkn.learnspringboot.runner;
 
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
 
@Component
public class TestImplCommandLineRunner implements CommandLineRunner {
 
 
    @Override
    public void run(String... args) throws Exception {
 
        System.out.println("<<<<<<<<<<<<这个是测试CommandLineRunn接口>>>>>>>>>>>>>>");
    }
}
```
执行结果为：

ApplicationRunner接口

具体代码如下：
```
package com.zkn.learnspringboot.runner;
 
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
 
/**
 * 注意：一定要有@Component这个注解。要不然SpringBoot扫描不到这个类,是不会执行。
 */
@Component
public class TestImplApplicationRunner implements ApplicationRunner {
 
 
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(args);
        System.out.println("这个是测试ApplicationRunner接口");
    }
}
```
执行结果如下：

@Order注解

如果有多个实现类，而你需要他们按一定顺序执行的话，可以在实现类上加上@Order注解。@Order(value=整数值)。SpringBoot会按照@Order中的value值从小到大依次执行。
Tips

如果你发现你的实现类没有按照你的需求执行，请看一下实现类上是否添加了Spring管理的注解（@Component）。