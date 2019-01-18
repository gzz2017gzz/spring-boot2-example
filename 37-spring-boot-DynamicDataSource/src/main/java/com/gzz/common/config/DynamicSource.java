package com.gzz.common.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author gzz_gzz@163.com
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