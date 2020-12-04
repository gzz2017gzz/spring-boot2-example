package com.gzz.common.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * @功能说明 拼加页面查询条件的基础类
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2020-02-02 02:20:20
 */
public abstract class BaseCondition {

	private static final List<Object> paramList = new ArrayList<>();// 参数值
	private static final StringBuffer condition = new StringBuffer();// 条件语句
//	@ApiModelProperty("页大小")
	private int size = 10;// 页大小(每页记录条)
//	@ApiModelProperty("当前页")
	private int page = 0;// 当前页码

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(String类型)
	 */
	final protected void add(final String sql, final String value) {
		if (!StringUtils.isEmpty(value)) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Short类型)
	 */
	final protected void add(final String sql, final Short value) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	final protected void add(final String sql, final Byte value) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 拼加条件使用等于大于小于....运算符(String类型)
	 */
	final protected void add(final String sql, final Float value) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Long类型)
	 */

	final protected void add(final String sql, final Long value) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Boolean类型)
	 */
	final protected void add(final String sql, final Boolean value) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 拼加条件使用等于大于小于....运算符(BigDecimal类型)
	 */
	final protected void add(final String sql, final BigDecimal value) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 拼加条件使用等于大于小于....运算符(Integer类型)
	 */
	final protected void add(final String sql, final Integer value) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Date类型)
	 */
	final protected void add(final String sql, final Date value) {
		if (value != null) {
			condition.append(" " + sql);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 不使用占位符直接拼SQL(不建议使用)
	 */
	final protected void add(final String sql) {
		if (null != sql && !"".equals(sql)) {
			condition.append(" " + sql);
		}
	}

	/**
	 * @功能 拼加条件in子句
	 */
	final protected void add(final String sql, final List<Object> ids) {
		if (!CollectionUtils.isEmpty(ids)) {
			condition.append(" " + sql + toIn(ids.toArray()));
			paramList.addAll(ids);
		}
	}

	/**
	 * @功能说明 拼加条件使用like关键字模糊查询时
	 */
	final protected void add(final String sql, final String value, final int pos) {
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
	final public Object[] array() {
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
	 * @方法说明 把组数拼接成(?,?,?)的形式
	 */
	final public static String toIn(final Object ids[]) {
		if (ids.length == 0) {
			throw new RuntimeException("数组参数个数不能为零!");
		}
		StringBuffer sb = new StringBuffer(" (?");
		for (int i = 1; i < ids.length; i++) {
			sb.append(",?");
		}
		sb.append(")");
		return sb.toString();
	}

	/**
	 * @功能说明 拼加条件方法
	 */
	public abstract void addCondition();

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
