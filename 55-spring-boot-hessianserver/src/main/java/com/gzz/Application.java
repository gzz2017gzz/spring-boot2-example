package com.gzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.gzz.sys.user.IHelloService;

/**
 * @功能描述 Hessian实例之服务器
 * @author www.gaozz.club
 * @date 2018-08-26
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
