package com.gzz.sys.field;

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
public class FieldCond extends BaseCondition {

	/**
	 * @方法说明: 拼加自定义条件
	 **/
	@Override
	public void addCondition() {
		add("AND t.field_id LIKE ?", field_id, 3);
		add("AND t.bus_id LIKE ?", bus_id, 3);
		add("AND t.field_name LIKE ?", field_name, 3);
		add("AND t.data_type LIKE ?", data_type, 3);
		add("AND t.data_length LIKE ?", data_length, 3);
		add("AND t.data_scale = ?", data_scale);
		add("AND t.field_remark LIKE ?", field_remark, 3);
		add("AND t.id IN", ids);
	}

	// 以下为查询条件
	private String field_id; // 主键
	private String bus_id; // 业务主键
	private String field_name; // 业务名称
	private String data_type; // 数据类型
	private String data_length; // 数据长度
	private Byte data_scale; // 小数位数
	private String field_remark; // 字段备注
	private List<Object> ids;// 主键列表
	// 以下为自定义查询条件
}