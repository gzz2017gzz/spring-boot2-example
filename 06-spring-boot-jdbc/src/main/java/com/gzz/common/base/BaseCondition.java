package com.gzz.common.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import lombok.Data;

/**
 * @功能说明 拼加页面查询条件的基础类
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2020-02-02 02:20:20
 */
@Data
public abstract class BaseCondition {

	private static final List<Object> paramList = new ArrayList<>();// 参数值
	private static final StringBuffer condition = new StringBuffer();// 条件语句
	private int size = 10;// 页大小(每页记录条)
	private int page = 0;// 当前页码

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(String类型)
	 */
	final protected void add(final String value, final String sql) {
		if (!StringUtils.isEmpty(value)) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Short类型)
	 */
	final protected void add(final Short value, final String sql) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	final protected void add(final Byte value, final String sql) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 拼加条件使用等于大于小于....运算符(String类型)
	 */
	final protected void add(final Float value, final String sql) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Long类型)
	 */

	final protected void add(final Long value, final String sql) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Boolean类型)
	 */
	final protected void add(final Boolean value, final String sql) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 拼加条件使用等于大于小于....运算符(BigDecimal类型)
	 */
	final protected void add(final BigDecimal value, final String sql) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 拼加条件使用等于大于小于....运算符(Integer类型)
	 */
	final protected void add(final Integer value, final String sql) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Date类型)
	 */
	final protected void add(final Date value, final String sql) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 不使用占位符直接拼SQL(不建议使用)
	 */
	@Deprecated
	final protected void add(final String sql) {
		if (null != sql && !"".equals(sql)) {
			condition.append(" " + sql);
		}
	}

	/**
	 * @功能 拼加条件in子句
	 */
	final protected void add(final List<Object> ids, final String sql) {
		if (!CollectionUtils.isEmpty(ids)) {
			condition.append(" " + sql + SqlUtil.in(ids.toArray()));
			paramList.addAll(ids);
		}
	}

	/**
	 * @功能说明 拼加条件使用like关键字模糊查询时
	 */
	final protected void add(final String value, final String sql, final int pos) {
		if (!StringUtils.isEmpty(value)) {
			condition.append(" " + sql);
			if (pos == 1) {
				paramList.add("%" + value);
			} else if (pos == 2) {
				paramList.add(value + "%");
			} else if (pos == 3) {
				paramList.add("%" + value + "%");
			}
		}
	}

	/**
	 * @功能说明 将List转为数组
	 */
	final public Object[] getArray() {
		return paramList.toArray();
	}

	/**
	 * @功能说明 把一个and换成where
	 */

	final public String where() {
		return and().replaceFirst("(?i)(AND)", "WHERE");
	}

	/**
	 * @功能说明 取条件字符串
	 */

	final public String and() {
		condition.setLength(0); // 清除查询条件
		paramList.clear();
		addCondition();
		return condition.toString();
	}

	/**
	 * @功能说明 拼加条件方法
	 */
	public abstract void addCondition();

}
