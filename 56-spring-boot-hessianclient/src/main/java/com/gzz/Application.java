package com.gzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.gzz.sys.user.IHelloService;

/**
 * @功能描述 Hessian实例之客户端
 * @author www.gaozz.club
 * @date 2018-08-26
 */
@SpringBootApplication
public class Application {
	@Bean
	public HessianProxyFactoryBean helloClient() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
		factory.setServiceUrl("http://localhost:8080/HelloService");
		factory.setServiceInterface(IHelloService.class);
		return factory;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
