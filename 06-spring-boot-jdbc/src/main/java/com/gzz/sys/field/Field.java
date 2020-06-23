package com.gzz.sys.field;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
/**
 * @类说明 【字段定义】实体
 * @author 高振中
 * @date 2020-06-17 18:03:53
 **/
@Setter
@Getter
//@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Field {
//	@NotNull(message = "客户主建(Id)不能为空(数值型)")
//	@NotEmpty(message = "客户名称(name)不能为空(字符型)")
//	@Length(max = 20, min = 10, message = "客户名称(name)长度在有10~20之间(字符型)")
//	@Max(value = 1000, message = "客户年龄(age)最大值是1000(数值型)")
//	@Min(value = 100, message = "客户年龄(age)最小值是100(数值型)")
//	@Pattern(regexp = "^\\d{10}$", message = "必须为10位数字(字符型[正规判断])")
	// 以下为数据库中 字段
	private String field_id; // 主键
	private String bus_id; // 业务主键
	private String field_name; // 业务名称
	private String data_type; // 数据类型
	private String data_length; // 数据长度
	private Byte data_scale; // 小数位数
	private String field_remark; // 字段备注
	// 以下为查询显示辅助属性
}