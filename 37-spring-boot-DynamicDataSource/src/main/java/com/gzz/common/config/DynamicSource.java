package com.gzz.common.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
public class DynamicSource extends AbstractRoutingDataSource {
	private static final ThreadLocal<String> context = new ThreadLocal<>();

	@Override
	protected Object determineCurrentLookupKey() {
		return context.get();
	}

	public static void setDB(String dbType) {
		context.set(dbType);
	}

	public static void setDefalt() {
		context.set("datasourceA");
	}
}