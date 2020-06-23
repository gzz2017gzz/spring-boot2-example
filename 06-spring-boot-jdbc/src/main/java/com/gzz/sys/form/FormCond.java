package com.gzz.sys.form;

import java.util.List;

import com.gzz.common.base.BaseCondition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @类说明 【字段定义】查询条件
 * @author 高振中
 * @date 2020-06-17 18:03:53
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormCond extends BaseCondition {

	/**
	 * @方法说明: 拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add("AND t.field_id LIKE ?", field_id, 3);
		add("AND t.type LIKE ?", type, 3);
		add("AND t.value LIKE ?", value, 3);
		add("AND t.title LIKE ?", title, 3);
		add("AND t.props LIKE ?", props, 3);
		add("AND t.validate LIKE ?", validate, 3);
		add("AND t.col = ?", col);
		add("AND t.dataSource LIKE ?", dataSource, 3);
		add("AND t.options LIKE ?", options, 3);
		add("AND t.order_num = ?", order_num);
		add("AND t.id IN", ids);
	}

	// 以下为查询条件
	private String field_id; // 字段主键
	private String type; // 控件类型
	private String value; // 默认值
	private String title; // 标题
	private String props; // 属性JSON
	private String validate; // 验证JSON
	private String col; // 布局列数
	private String dataSource; // 数据来源JSON
	private String options; // 数据项
	private Integer order_num; // 顺序
	private List<Object> ids;// 主键列表
	// 以下为自定义查询条件
}