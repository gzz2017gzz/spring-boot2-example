package com.gzz.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gzz_gzz@163.com
 * @功能说明: 拼加页面查询条件的基础类
 * @date 2018-02-15
 */

public abstract class BaseCondition {
	protected Log logger = LogFactory.getLog(getClass());// 日志类
	private List<Object> paramList = new ArrayList<>();// 参数值

	private StringBuffer condition = new StringBuffer();// 条件语句

	private Integer size = 10;// 页大小(每页记录条)

	private Integer page = 0;// 当前页码

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(String类型)
	 */
	protected void add(String value, String strSQL) {
		if (null != strSQL && null != value && !"".equals(strSQL) && !"".equals(value)) {
			condition.append(" ");
			condition.append(strSQL);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Short类型)
	 */
	protected void add(Short value, String strSQL) {
		if (null != strSQL && null != value && !"".equals(strSQL)) {
			condition.append(" ");
			condition.append(strSQL);
			paramList.add(value);
		}
	}

	protected void add(Byte value, String strSQL) {
		if (null != strSQL && null != value && !"".equals(strSQL)) {
			condition.append(" ");
			condition.append(strSQL);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(String类型)
	 */
	protected void add(Float value, String strSQL) {
		if (null != strSQL && null != value && !"".equals(strSQL)) {
			condition.append(" ");
			condition.append(strSQL);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Long类型)
	 */

	protected void add(Long value, String strSQL) {
		if (null != strSQL && null != value && !"".equals(strSQL)) {
			condition.append(" ");
			condition.append(strSQL);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Boolean类型)
	 */
	protected void add(Boolean value, String strSQL) {
		if (null != strSQL && null != value && !"".equals(strSQL)) {
			condition.append(" ");
			condition.append(strSQL);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 拼加条件使用等于大于小于....运算符(BigDecimal类型)
	 */
	protected void add(BigDecimal value, String strSQL) {
		if (null != strSQL && null != value && !"".equals(strSQL)) {
			condition.append(" ");
			condition.append(strSQL);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 拼加条件使用等于大于小于....运算符(Integer类型)
	 */
	protected void add(Integer value, String strSQL) {
		if (null != value && !"".equals(strSQL) && null != strSQL) {
			condition.append(" ");
			condition.append(strSQL);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明: 拼加条件使用等于大于小于....运算符(Date类型)
	 */
	protected void add(Date value, String strSQL) {
		if (null != value && !"".equals(strSQL) && null != strSQL) {
			condition.append(" ");
			condition.append(strSQL);
			paramList.add(value);
		}
	}

	/**
	 * @功能说明 拼加条件
	 */
	protected void add(String strSQL) {
		if (null != strSQL && !"".equals(strSQL)) {
			condition.append(" ");
			condition.append(strSQL);
		}
	}

	/**
	 * @功能说明 拼加条件
	 */
	protected void add(List<?> ids, String strSQL) {
		if (null != strSQL && !"".equals(strSQL) && ids != null && ids.size() > 0) {
			condition.append(" ");
			condition.append(strSQL);
			condition.append(SqlUtil.ArrayToIn(ids));
		}
	}

	/**
	 * @param value  :属性名称
	 * @param strSQL :参数SQL字符
	 * @param pos    :字句中百分号出现位置
	 * @功能说明 拼加条件使用like关键字模糊查询时
	 */
	protected void add(String value, String strSQL, int pos) {
		if (null != strSQL && null != value && !"".equals(strSQL) && !"".equals(value)) {
			condition.append(" ");
			condition.append(strSQL);
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
	public Object[] getArray() {
		return paramList.toArray();
	}

	/**
	 * @功能说明: 取条件字符串
	 */

	public String getCondition() {
		condition.setLength(0);// 清除查询条件
		paramList.clear();
		addCondition();
		return condition.toString();
	}

	/**
	 * @功能说明 拼加条件方法
	 */
	public abstract void addCondition();

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

}
