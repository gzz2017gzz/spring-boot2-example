package com.gzz.common.base;

import java.text.SimpleDateFormat;

/**
 * @功能描述:SQL工具
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2020-02-02 02:20:20
 */
public final class SqlUtil {
	/**
	 * @方法说明:数据库中执行的SQL语句
	 */
	public static final String showSql(String sql, final Object[] obj) {
		String param;
		for (int j = 0; null != obj && j < obj.length; j++) {
			param = "null";
			if (null != obj[j]) {
				String cname = obj[j].getClass().getName();
				if (cname.contains("Date") || cname.contains("Timestamp")) {
					param = "'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(obj[j]) + "'";
				} else if (cname.contains("String")) {
					param = "'" + (String) obj[j] + "'";
				} else {
					param = obj[j].toString();
				}
			}
			sql = sql.replaceFirst("[?]", param);
		}
		return sql;
	}

	/**
	 * @方法说明 把组数拼接成(?,?,?,?,?,?,?,?)的形式
	 */
	public static final String in(final Object ids[]) {
//		if (ids == null || ids.length < 1) {
//			log.error("》》》数组条件的长度为0,拼加条件失败");
//			throw new RuntimeException("数组条件的长度为0,拼加条件失败");
//		}
		StringBuffer sb = new StringBuffer(" (?");
		for (int i = 1; i < ids.length; i++) {
			sb.append(",?");
		}
		sb.append(")");
		return sb.toString();
	}
}
