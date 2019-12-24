package com.gzz.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 自定义健康端点
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@Component("my1")
public class MyHealthIndicator implements HealthIndicator {

	private static final String VERSION = "v1.0.0";

	@Override
	public Health health() {
		int code = check();
		if (code != 0) {
			Health.down().withDetail("code", code).withDetail("version", VERSION).build();
		}
		return Health.up().withDetail("code", code).withDetail("version", VERSION).up().build();
	}

	private int check() {

		return 0;
	}
}
