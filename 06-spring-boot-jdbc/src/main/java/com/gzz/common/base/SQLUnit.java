package com.gzz.common.base;

/**
 * @功能描述:SQL工具
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2020-02-02 02:20:20
 */
public final class SQLUnit {
	/**
	 * @方法说明 把组数拼接成(?,?,?)的形式
	 */
	final public static String toIn(final Object ids[]) {
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
