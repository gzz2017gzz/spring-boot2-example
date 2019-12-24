package com.gzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.gzz.sys.user.IHelloService;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@SpringBootApplication
public class Application {

	@Autowired
	private IHelloService service;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean(name = "/HelloService")
	public HessianServiceExporter accountService() {
		HessianServiceExporter exporter = new HessianServiceExporter();
		exporter.setService(service);
		exporter.setServiceInterface(IHelloService.class);
		return exporter;
	}
}
